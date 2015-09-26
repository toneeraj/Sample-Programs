package demo4;

import java.util.Scanner;

//Shutting down one thread from another gracefully. Demostrating volatile keyword.
class Processor extends Thread {
	
	//Use of volatile keyword is demonstrated here.
	
	//Volatile keyword is used to prevent a thread from caching the value of the
	//variable. When main thread modifies the value of running, as we are using 
	//volatile, it will not allow Processor thread to cache it.
	private volatile boolean running = true;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		while (running) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void shutdown () {
		running = false;
	}
}
public class App {
	public static void main(String[] args) {
		Processor processor = new Processor ();
		processor.start();
		
		System.out.println("Press return to stop");
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner (System.in);
		scanner.nextLine();
		
		processor.shutdown();
		
		
	}

}
