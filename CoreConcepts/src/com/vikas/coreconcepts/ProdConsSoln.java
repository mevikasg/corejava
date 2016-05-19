package com.vikas.coreconcepts;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProdConsSoln {

	int count=0;
		
	public static void main(String[] args){
		
		ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(500);
		
		Producer p = new Producer(queue); 
		
		Consumer c = new Consumer(queue);
			
	}	
}
