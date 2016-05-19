package com.vikas.thread;

public class Methods {
	
	private int i = 0;
	private boolean flag = false;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public int getI() {
		return i;
	}

	public synchronized int increase() {
	
		if(!flag) {
			System.out.println("It's Increament Time ... "+Thread.currentThread().getName());
			++i;
			flag = true;
			System.out.println("Notified to decrement ... "+i);
			this.notify();
		}	
		else {
			try {
//				System.out.println("A = "+i + " Time to Decreament -> waiting");
				this.wait();
			} catch (InterruptedException e) {
				System.out.println("Methods.increase(): "+e.getLocalizedMessage());
			}
		}
		return i;
	}


	public synchronized int decrease() {
		
		if (flag) {
			System.out.println("It's Decreament Time ...");
			--i;
			flag = false;
			System.out.println("Notified to Increment ... "+i);
			this.notify();
		}
		else {
			try {
//				System.out.println("B = "+i + " Time to Increament -> waiting");
				this.wait();
			} catch (InterruptedException e) {
				System.out.println("Methods.decrease(): "+e.getLocalizedMessage());
			}
		}
		return i;
	}
	
	/* 
	 * 
	  	It's Increament Time ...
		Notified to decrement ... 1
		It's Decreament Time ...
		Notified to Increment ... 0
		B = 0 Time to Increament -> waiting
		It's Increament Time ...
		Notified to decrement ... 1
		A = 1 Time to Decreament -> waiting
		It's Decreament Time ...
		Notified to Increment ... 0
		B = 0 Time to Increament -> waiting
		It's Increament Time ...
		Notified to decrement ... 1
		A = 1 Time to Decreament -> waiting
		It's Decreament Time ...
		Notified to Increment ... 0

	 * 
	 * */
	
	
	public synchronized void callQuestions(String ques) {
		this.notify();
		if(flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(ques);
		flag = true;		
	}
	
	
	public synchronized void callAnswers(String ans) {
		
		if(!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(ans);
		flag = false;
		this.notify();
	}
	
}
