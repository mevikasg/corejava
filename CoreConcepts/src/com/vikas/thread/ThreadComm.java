/**
 * 
 */
package com.vikas.thread;

/**
 * @author vgupta
 *
 */
public class ThreadComm {

	public static void main(String[] args) {
		
		Methods methods = new Methods(); 
		
		Thread t1 = new Thread(new ThreadA(methods));
		
		Thread t2 = new Thread(new ThreadB(methods));
		
		
		
		/*
		t1.start();
		t2.start();*/
		
		/*
		Thread quesT = new Thread(new QuestionsThread(methods));
		Thread ansT = new Thread(new AnswersThread(methods));
		
		quesT.start();
		ansT.start();*/

	}
	
	
}
