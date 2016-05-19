package com.vikas.coreconcepts;

public class OldProducer implements Runnable {

	Integer count=0;
	
	public OldProducer(Integer count){
		
		this.count = count;
	}
	
	
	public Integer produce() throws InterruptedException{
		synchronized(count){
			++count;
			
//			count.notify();
			
		}	
		return count;
	}
	
	@Override
	public void run() {
		
		for(int i=0;i<7;i++){
			try {
				System.out.println("Produce: "+produce());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
