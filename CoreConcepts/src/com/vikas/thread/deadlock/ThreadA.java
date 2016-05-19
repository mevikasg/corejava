package com.vikas.thread.deadlock;


public class ThreadA implements Runnable{

	Account a1 = null;
	Account a2 = null;
	
	public ThreadA (Account a1, Account a2) {
		setA1(a1);
		setA2(a2);
	}
	
	public Account getA1() {
		return a1;
	}

	public void setA1(Account a1) {
		this.a1 = a1;
	}

	public Account getA2() {
		return a2;
	}

	public void setA2(Account a2) {
		this.a2 = a2;
	}

	public void run(){
		
		synchronized (getA1()) {
			a1.deposit(100);
			try {
				System.out.println("A = "+a1.getBalance() + " Sleep");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Waiting for lock B ...");
			synchronized (getA2()) {
				a2.deposit(100);
				System.out.println("B = "+a2.getBalance());
			}
			
		}
		
	}
	
	
}
