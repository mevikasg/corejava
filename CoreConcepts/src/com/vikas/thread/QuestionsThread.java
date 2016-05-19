package com.vikas.thread;

public class QuestionsThread implements Runnable{
	
	private Methods methods = null;
	private String questions[] = {"Hi ","How are you doing?", "I'm good too!"};
	
	public QuestionsThread(Methods methods) {
		this.methods = methods;
	}
	
	public void run(){
		
		for (int i = 0; i < questions.length; i++) {
			methods.callQuestions(questions[i]);
		}
		
	}

}
