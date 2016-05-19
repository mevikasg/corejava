package com.vikas.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

	public static void main(String[] args) {

		CyclicBarrier cb1 = new CyclicBarrier(2, new  Runnable() {
			
			@Override
			public void run() {
				System.out.println("Passed Barrier 1");
				
			}
		});
		
		CyclicBarrier cb2 = new CyclicBarrier(2, new  Runnable() {
			
			@Override
			public void run() {
				System.out.println("Passed Barrier 2");
				
			}
		});
		
		
		
		CyclicBarrierRunnable cbR1 = new CyclicBarrierRunnable(cb1, cb2);
		
		CyclicBarrierRunnable cbR2 = new CyclicBarrierRunnable(cb1, cb2);
		
		Thread t1 = new Thread(cbR1);
		Thread t2 = new Thread(cbR2);
		
		
		t1.start();
		t2.start();
		
	}
	
	
	

}

class CyclicBarrierRunnable implements Runnable{
	
 CyclicBarrier cb1 = null;
 CyclicBarrier cb2 = null;
 
 public CyclicBarrierRunnable (CyclicBarrier cb1, CyclicBarrier cb2) {
	 
	 this.cb1 = cb1;
	 this.cb2 = cb2;
 }

	@Override
	public void run() {

//		System.out.println("Inside CBRunnable "+ Thread.currentThread().getName());
		
		try {
			Thread.sleep(1000);
			System.out.println("Waiting for barrier "+Thread.currentThread().getName());
			this.cb1.await();			
			
			Thread.sleep(1000);
			
			System.out.println("Waiting for barrier "+Thread.currentThread().getName());
			this.cb2.await();
			
			
			System.out.println("Yuhooo passed the barriers "+ Thread.currentThread().getName());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 // Why application execution is completed when 1 barrier get commented		
		
	}

}