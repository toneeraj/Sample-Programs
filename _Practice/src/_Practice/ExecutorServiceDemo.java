package _Practice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		
		
		//Create Executor Service and get threads ready to service from Future Facotry method
		
		//Create Future which will hold the result.
		
		//Executor will submit the results to future. Check the role of Callable
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		Future<Integer> future = executorService.submit (new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				return new Integer(10);
			}
			
		});
		
		System.out.println(future.get());
		
		
		
	}
}
