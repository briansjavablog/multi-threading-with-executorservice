package com.briansjavablog.concurrency.threads;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.junit.Test;

public class ExecutorServiceCallableSampleTest {
	
	@Test
	public void submitCallablesWithExecutor() throws InterruptedException, ExecutionException, TimeoutException{
		
		Instant start = Instant.now();		
		
		new ExecutorServiceCallableSample().submitCallablesWithExecutor();		
		
		System.out.println(String.format("submitCallablesWithExecutor took %s ms", 
								ChronoUnit.MILLIS.between(start, Instant.now())));
	}
	
	@Test
	public void submitCollectionOfCallablesWithExecutor() throws InterruptedException, ExecutionException, TimeoutException{
		
		Instant start = Instant.now();
		
		new ExecutorServiceCallableSample().submitMultipleCallablesWithExecutor();		
		
		System.out.println(String.format("submitMultipleCallablesWithExecutor took %s ms", 
								ChronoUnit.MILLIS.between(start, Instant.now())));
	}
}
