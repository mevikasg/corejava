package com.vikas.thread.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Account {
	
	private double balance = 0.0;

	private Lock lock = new ReentrantLock();
	
	public synchronized void deposit(double amount) {
		
		setBalance(getBalance() + amount);
		System.out.println("Deposited by " + Thread.currentThread().getName());
		
	}

	public synchronized void withdraw(double amount) {
			
			setBalance(getBalance() - amount);
			
		
		System.out.println("Withdraw by " + Thread.currentThread().getName());
		
	}

	
	public  void withdrawWOSync(double amount) throws InterruptedException {
		try {
			lock.lock();
			setBalance(getBalance() - amount);
			
			Thread.currentThread().sleep(1000);
		}
		finally {
			lock.unlock();
		}	
		
		System.out.println("Withdraw by " + Thread.currentThread().getName());
		
	}

	public void depositWOSync(double amount) throws InterruptedException {
		
		try {
			lock.lock();
			setBalance(getBalance() + amount);
			
			Thread.currentThread().sleep(1000);

		}
		finally {
			lock.unlock();
		}	
		
		System.out.println("Deposited by " + Thread.currentThread().getName());
		
	}
	
	
	public double getBalance() {
		
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
