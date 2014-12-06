//Linda.com code clinic java program shows the thread communication and accessing music library.

public class Main {
	
	public static void main(String[] args) {
		new Thread(new MouseChecker()).start();
	}
}
