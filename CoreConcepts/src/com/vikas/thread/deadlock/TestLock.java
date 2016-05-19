package com.vikas.thread.deadlock;

import java.util.concurrent.TimeUnit;

public class TestLock {
	
	Account acnt = new Account();
	public static void main(String[] args) throws InterruptedException {
		TestLock tl = new TestLock();
		//tl.m1();
		//TimeUnit.SECONDS.sleep(1);
		//tl.m2();
		
		Thread t1 = new Thread();
		t1.start();
		Thread.currentThread().sleep(1000);
		System.out.println("Hi" + t1.getState());
		Thread.currentThread().join();
	}
	
	private void m2() {
	
		acnt.deposit(200d);
		
	}

	public void m1(){
		Thread t1 = new Thread( new Runnable(){
			public void run() {
				synchronized (acnt) {
					try {
					acnt.deposit(100d);
					System.out.println("100 deposited");					
					TimeUnit.SECONDS.sleep(10);
					System.out.println("Done");
					
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		t1.start();
	}
}
