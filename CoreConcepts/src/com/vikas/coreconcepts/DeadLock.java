package com.vikas.coreconcepts;

public class DeadLock {

	String lName="Gupta";
	String fName="Vikas";


	Thread t1 = new Thread("T1"){

		public void run(){

			System.out.println(Thread.currentThread().getName());
			while(true){
				synchronized (fName) {

					synchronized (lName) {

						System.out.println(fName+lName);
					}

				}
			}
		}
	};


	Thread t2 = new Thread("T2"){

		public void run(){
			System.out.println(Thread.currentThread().getName());
			while(true){
				synchronized (lName) {
					synchronized (fName) {
						System.out.println(lName+fName);

					}
				}
			}	
		}
	};




}
