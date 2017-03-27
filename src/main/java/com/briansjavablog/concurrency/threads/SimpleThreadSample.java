package com.briansjavablog.concurrency.threads;

public class SimpleThreadSample {
	
	/**
	 * Call 2 expensive methods one after the other
	 */
	public void doSingleThreadedWork(){
		
		System.out.println("starting expensive task");
		doSomethingExpensive();
		System.out.println("finishing expensive task");
		
		System.out.println("starting expensive task");
		doSomethingExpensive();
		System.out.println("finishing expensive task");
	}
	
	
	/**
	 * Call 2 expensive methods, this time on a separate 
	 * threads. Calls will happen in parallel make overall
	 * method execution time significant shorter 	 
	 * @throws InterruptedException 
	 */
	public void doMultiThreadedWork() throws InterruptedException{
		
		/* create Runnable using anonymous inner class */
		Thread t1 = new Thread(new Runnable() {			
			public void run() {
				System.out.println("starting expensive task thread t1");
				doSomethingExpensive();				
				System.out.println("finished expensive task thread t1");
			}
		});
		
		/* create Runnable using lambda */
		Thread t2 = new Thread(()-> {						
				System.out.println("starting expensive task thread t2");
				doSomethingExpensive();				
				System.out.println("finished expensive task thread t2");			
			});
		
		/* start processing on new threads */
		t1.start();		
		t2.start();		
		
		/* block current thread until t1 and t2 have finished */
		t1.join();
		t2.join();
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
