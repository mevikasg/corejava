package com.vikas.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TestExecutorServ {
public static void main(String[] args) throws InterruptedException, ExecutionException {
	ExecutorService service = Executors.newScheduledThreadPool(1);	
	//service.execute(new MyTask());
	MyCallable mc = new MyCallable();
	
	
	Future<String> results = service.submit(mc);
	System.out.println(results.get());
	//ExecutorCompletionService<V>
}

}


class MyCallable implements Callable<String>{
	public String call() throws Exception {
	TimeUnit.SECONDS.sleep(3);
		return "hello";	
	}
	
	
}


class MyTask implements Runnable{
	@Override
	public void run() {
		System.out.println("Hi");
	}
	
}