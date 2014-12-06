import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueSample {
	public static void main(String[] args) {

		
		//created and added elements to priority queue
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
		pq1.offer(400);
		pq1.offer(19);
		pq1.offer(-1);
		
		
		//print the least element
		System.out.println("Least element in the priority queue is always pointed by Head iS  " + pq1.peek());
	
		//Printing the priority queue via iterator doesn't guarantee that results will be ordered
		Iterator<Integer> iter = pq1.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		//Ensuring that sorted array gets printed
		Object[] intArr = pq1.toArray();
		Arrays.sort(intArr);
		
		//printing the elements of Object Array
		for (Object o : intArr) {
			System.out.println(o);
		}
	
	}
}
