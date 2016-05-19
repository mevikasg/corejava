package com.vikas.coreconcepts;

public class MySingleton {
	
	public static MySingleton instance = new MySingleton();
	
	private MySingleton() {
		if(MySingleton.instance != null) {
			try {
				throw new InstantiationException("Singleton Object already instantiated. So, no new one will be created!!!");
			} catch (InstantiationException e) {
				System.out.println(""+e.getLocalizedMessage());
				System.exit(1);
			}
		}
		
	};
	
	public static MySingleton getInstance(){
		return instance;
	}
	
	public void print(){
		
		System.out.println("Singleton Object accessed...");
	}
	
	public void hackedPrint(){
		
		System.out.println("Boom !!! Singleton hacked...");
	}
}
