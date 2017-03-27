package com.briansjavablog.concurrency.threads;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.junit.Test;

public class ExecutorServiceRunnableSampleTest {

	@Test
	public void executeRunnablesWithExecutor() throws InterruptedException{
		
		Instant start = Instant.now();		
		
		new ExecutorServiceRunnableSample().executeRunnablesWithExecutor();		
		
		System.out.println(String.format("executeRunnablesWithExecutor took %s ms", 
								ChronoUnit.MILLIS.between(start, Instant.now())));
	}
	
	@Test
	public void submitRunnablesWithExecutor() throws InterruptedException, ExecutionException, TimeoutException{
		
		Instant start = Instant.now();		
		
		new ExecutorServiceRunnableSample().submitRunnablesWithExecutor();		
		
		System.out.println(String.format("submitRunnablesWithExecutor took %s ms", 
								ChronoUnit.MILLIS.between(start, Instant.now())));
	}
}
