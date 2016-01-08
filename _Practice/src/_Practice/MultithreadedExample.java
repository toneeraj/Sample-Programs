package _Practice;

class ThreadExample implements Runnable {
	private int count = 0;
	

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		for (int i = 0; i < 100; i++) {
			count = count + 1;
			System.out.println(threadName + " " +count);
			
		}

	}
}

public class MultithreadedExample {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new ThreadExample());
		t1.start();
		

		Thread t2 = new Thread(new ThreadExample());
		t2.start();
	}

}
