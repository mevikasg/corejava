package com.vikas.thread.deadlock;

public class Deadlock {

	
	
	public static void main(String[] args) {
		
		Account a1 = new Account();
		Account a2 = new Account();
		
		Thread t1 = new Thread(new ThreadA(a1,a2));
		Thread t2 = new Thread(new ThreadB(a1,a2));

		t1.start();
		t2.start();
		
	}

}
