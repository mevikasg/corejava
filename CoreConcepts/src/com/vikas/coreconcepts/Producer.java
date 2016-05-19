package com.vikas.coreconcepts;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
	
	BlockingQueue<Integer> queue = null;
	
	public Producer(BlockingQueue<Integer> queue){
		
		this.queue = queue;
	}
	
	
	public void produce(){
		
		try {
			System.out.println("Produce: 1");queue.put(1);
			Thread.sleep(1000);
			System.out.println("Produce: 2");queue.put(2);
			Thread.sleep(1000);
			System.out.println("Produce: 3");queue.put(3);
			Thread.sleep(10000);
			System.out.println("Produce: 4");queue.put(4);
			Thread.sleep(10000);
			System.out.println("Produce: 5");queue.put(5);
//			Thread.sleep(1000);
			System.out.println("Done ... ");
			
		} catch (InterruptedException e) {
			System.out.println("Over Produced ... Waiting..");
		}
		
	}
	
	public void run(){
		
		produce();
		
		
	}

}
