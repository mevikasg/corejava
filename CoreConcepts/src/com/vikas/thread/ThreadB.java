package com.vikas.thread;

public class ThreadB implements Runnable{
	
	private int j = 0;
	private Methods methods = null;
	
	public ThreadB (Methods methods) {
		this.methods = methods;
	}
		
	public void run(){
		
		for(int i = 0 ; i < 5; i++) {
			methods.decrease();
		}	
		
	}
	

	
}
