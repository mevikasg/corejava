package com.vikas.coreconcepts;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	BlockingQueue<Integer> queue = null;

	public Consumer(BlockingQueue<Integer> queue){
		this.queue = queue;
	}

	public void consume() {

		try {
			System.out.println("consume: "+queue.take());
			System.out.println("consume: "+queue.take());
			System.out.println("consume: "+queue.take());
			System.out.println("consume: "+queue.take());
			System.out.println("consume: "+queue.take());
			
			System.out.println("Exit ...");
		} catch (InterruptedException e) {
			System.out.println("Nothing to consume... Waiting ...");
		}

	}

	public void run() {

		consume();		
	}

}
