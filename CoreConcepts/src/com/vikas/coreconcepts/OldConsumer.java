package com.vikas.coreconcepts;

public class OldConsumer implements Runnable {

	Integer count=0;
	
	public OldConsumer(Integer count){
		
		this.count = count;
	}
	
	public  Integer consume() throws InterruptedException{
		
		synchronized (count) {
			
			if(count > 0){
				
				count.notifyAll();
				
				count--;
				
			}
		}
		
		synchronized (count) {
			
			if(count <1 ){
					count.wait();
					System.out.println("Nothing to consume.. .waiting");
				
			}
		}
		
		
		return count;
	}
	
	@Override
	public void run() {

		try {
			System.out.println("Consumed: "+consume());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
