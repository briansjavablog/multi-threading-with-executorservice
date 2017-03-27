package com.briansjavablog.concurrency.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorServiceRunnableSample {
	
	
	/**
	 * Use an ExecutorService to execute 2 Runnables that call expensive methods.
	 * Note the return type from the execute method is void
	 *  
	 * @throws InterruptedException 
	 */
	public void executeRunnablesWithExecutor() throws InterruptedException{
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		ExecutorService executorService = null;
		
		try{		
			
			executorService = Executors.newFixedThreadPool(2);
			
			executorService.execute(()->{
				System.out.println(String.format("starting expensive task thread %s", 
													Thread.currentThread().getName()));
				doSomethingExpensive();				
				System.out.println(String.format("finished expensive task thread %s", 
													Thread.currentThread().getName()));
			});
			
			executorService.execute(()->{
				System.out.println(String.format("starting expensive task thread %s", 
													Thread.currentThread().getName()));
				doSomethingExpensive();				
				System.out.println(String.format("finished expensive task thread %s", 
													Thread.currentThread().getName()));
			});
		}
		finally{
			executorService.shutdown();	
			executorService.awaitTermination(5, TimeUnit.SECONDS);
		}		
		
		executorService.execute(()->{
			System.out.println(String.format("starting expensive task thread %s", 
												Thread.currentThread().getName()));
			doSomethingExpensive();							
		});
	}
	
	
	/**
	 * Use an ExecutorService to execute 2 Runnables that call expensive methods.
	 * Note the return type from the execute method is void
	 *  
	 * @throws InterruptedException 
	 * @throws TimeoutException 
	 * @throws ExecutionException 
	 */
	public void submitRunnablesWithExecutor() throws InterruptedException, ExecutionException, TimeoutException{
	
		ExecutorService executorService = null;
		
		try{		
			executorService = Executors.newFixedThreadPool(2);
			
			Future<?> task1Future = executorService.submit(()->{
				System.out.println(String.format("starting expensive task thread %s", 
													Thread.currentThread().getName()));
				doSomethingExpensive();				
				System.out.println(String.format("finished expensive task thread %s", 
													Thread.currentThread().getName()));
			});
			
			Future<?> task2Future = executorService.submit(()->{
				System.out.println(String.format("starting expensive task thread %s", 
													Thread.currentThread().getName()));
				doSomethingExpensive();				
				System.out.println(String.format("finished expensive task thread %s", 
													Thread.currentThread().getName()));
			});
			
			/* check if both tasks have completed - if not sleep current thread 
			 * for 1 second and check again
			 */
			while(!task1Future.isDone() || !task2Future.isDone()){
				System.out.println("Task 1 and Task 2 are not yet complete....sleeping");
				Thread.sleep(1000);
			}			
		}
		finally{
			executorService.shutdown();				
		}		
	}
	
	/**
	 * Method sleeps for 3 seconds to simulate an expensive operation. 
	 * In reality this could be something like a remote call
	 */
	private void doSomethingExpensive(){
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}		
	}
}
