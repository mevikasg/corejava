package com.vikas.thread.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class ReentrantLockTestVikas {


	Account account1 = new Account();
	Account account2 = new Account();
	Lock reentLock = new ReentrantLock();
	

	public static void main(String[] args) {
		ReentrantLockTestVikas vikas = new ReentrantLockTestVikas();	

		vikas.callTest();
	}

	private  void callTest() {

		Thread t = new Thread(new Runnable() {

			public void run() {
				
				account1.getBalance();
				account1.deposit(100);
				
				
				
			}});
		
		
		Thread t2 = new Thread(new Runnable() {

			public void run() {
				
				account2.getBalance();
				
				account2.deposit(100);
			}});
		
		Thread t3 = null;
		try {
			t3 = new Thread(new Runnable() {

				public void run() {
					
					account1.withdraw(50);
				}});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t.start();
		t2.start();
		t3.start();
		
		
	}	
}


