package com.briansjavablog.concurrency.threads;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

public class SimpleThreadSampleTest {
	
	@Test
	public void singleThreadedProcessing(){
		
		SimpleThreadSample threadExample = new SimpleThreadSample();
		
		LocalDateTime start = LocalDateTime.now();		
		
		threadExample.doSingleThreadedWork();		
		
		System.out.println(String.format("doSingleThreadedWork took %s ms", 
						ChronoUnit.MILLIS.between(start, LocalDateTime.now())));
	}
	
	@Test
	public void multiThreadedProcessing() throws InterruptedException{
		
		SimpleThreadSample threadExample = new SimpleThreadSample();
		
		LocalDateTime start = LocalDateTime.now();		
		
		threadExample.doMultiThreadedWork();		
		
		System.out.println(String.format("doMultiThreadedWork took %s ms", 
							ChronoUnit.MILLIS.between(start, LocalDateTime.now())));
	}
}
