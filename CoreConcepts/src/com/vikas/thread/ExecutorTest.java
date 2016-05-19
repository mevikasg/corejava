package com.vikas.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorTest {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*ExecutorTest executor = new ExecutorTest();
		
		ExecutorService executors = Executors.newSingleThreadExecutor();
		executors.execute(new MyTaskExec());
		executors.shutdown();
		*/
		
		ExecutorService exeService = Executors.newFixedThreadPool(2);
		/*exeService.execute(new MyTaskExec());
		exeService.shutdown();*/
		
		
		/*Future result = exeService.submit(new MyTaskExec());
		
		try {
			System.out.println("Result: "+result.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*Future<Integer> result = exeService.submit(new Callable() {

			@Override
			public Integer call() throws Exception {
				Methods methods = new Methods();
				
				System.out.println("Inside = "+methods.getI());
				methods.increase();
				return Integer.valueOf(methods.getI());
			}
			
		
		});
		
		try {
			System.out.println(result.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		exeService.shutdown();
	}


}

class MyTaskExec implements Runnable{
	
		public void run() {
			
			Methods methods = new Methods();
			
			System.out.println("I = "+methods.getI());
			
			
		}
}