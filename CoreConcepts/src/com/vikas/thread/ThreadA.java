/**
 * 
 */
package com.vikas.thread;

/**
 * @author vgupta
 *
 */
public class ThreadA implements Runnable{
	
	private int j = 0;
	private Methods methods = null;
	
	public ThreadA (Methods methods) {
		this.methods = methods;
	}
		
	public void run(){
		
		for(int i = 0 ; i < 5; i++) {
			methods.increase();
		}	
	}
	
		
}
