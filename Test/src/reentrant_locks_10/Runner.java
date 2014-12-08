package reentrant_locks_10;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();

	private void increment() {
		for (int i = 0; i < 10000; i++) {
			count++;
		}
	}

	public void firstThread() throws InterruptedException {
		try {
			lock.lock();
			increment();
		} finally {
			lock.unlock();
		}
		
	}

	public void secondThread() throws InterruptedException {
		try {
			lock.lock();
			increment();
		} finally {
			lock.unlock();
		}
	}

	public void finished() throws InterruptedException {
		System.out.println("Count is: " + count);
	}

}
