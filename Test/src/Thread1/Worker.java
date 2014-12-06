package Thread1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {

	private Random random = new Random();

	public List<Integer> list1 = new ArrayList<>();
	public List<Integer> list2 = new ArrayList<>();

	// Create two objects for lock

	Object lock1 = new Object();
	Object lock2 = new Object();

	public void stageOne() {

		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list1.add(random.nextInt());
		}
	}

	public synchronized void stageTwo() {

		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list2.add(random.nextInt());
		}

	}

	public void process() {
		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();

		}
	}

	public void main() {
		System.out.println("Starting...");

		long start = System.currentTimeMillis();

		// CREATE And start a thread which will run process method
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				process();

			}

		});

		// create and start another thread which will also run process method
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				process();

			}

		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();

		System.out.println("Time takes = " + (end - start));
		System.out.println("list1.size()= " + list1.size() + " list2.size() = "
				+ list2.size());
	}
}
