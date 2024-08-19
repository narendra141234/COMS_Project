package com.narentech.threadpool;

import java.time.LocalDateTime;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NoRejectionFixedThreadPoolWithUnboundedQueue {
	public static void main(String[] args) {

		int corePoolSize = 5;
		int maxPoolSize = 5;
		long keepAliveTimeout = 0L;

		LinkedBlockingDeque<Runnable> unboundedQueue = new LinkedBlockingDeque<>();

		ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTimeout,
				TimeUnit.MILLISECONDS, unboundedQueue);

		System.out.println("--------------------Starting to Submit Tasks----------------------");
		for (int i = 1; i <= 20; i++) {
			MyRunnable runnable = new MyRunnable(i);
			executor.execute(runnable);
		}
		executor.shutdown();
		System.out.println("Finished Submitting All Tasks");
	}

}

class MyRunnable implements Runnable {

	private final int taskNumber;

	public MyRunnable(int taskNumber) {
		this.taskNumber = taskNumber;

	}

	@Override
	public void run() {
		System.out.println(LocalDateTime.now() + "Task Number " + this.taskNumber + " started,,going to sleep");
		try {
			Thread.sleep(60 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(LocalDateTime.now()+"Task Number "+ this.taskNumber+" finished execution");

	}

}
