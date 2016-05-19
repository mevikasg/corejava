package com.vikas.thread;

public class AnswersThread implements Runnable{
	
	private Methods methods;
	private String answers[] = {"Hi", "I'm doing good. how about you?"};
	
	public AnswersThread(Methods methods) {
		this.methods = methods;
	}
	
	public void run(){
		
		for(int i = 0; i < answers.length; i++){
			methods.callAnswers(answers[i]);
		}
		
		
	}
	

}
