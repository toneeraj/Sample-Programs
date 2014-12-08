import java.util.Arrays;
import java.util.BitSet;


public class App {
	
	/**
	    * A general method to find missing values from an integer array in Java.
	    * This method will work even if array has more than one missing element.
	    */
	    private static void printMissingNumber(int[] numbers, int count) {
	        int missingCount = count - numbers.length;
	        BitSet bitSet = new BitSet(count);
	 
	        for (int number : numbers) {
	            bitSet.set(number - 1);
	        }
	 
	        System.out.printf("Missing numbers in integer array %s, with total number %d is %n",
	        Arrays.toString(numbers), count);
	        int lastMissingIndex = 0;

	        for (int i = 0; i < missingCount; i++) {
	            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
	            System.out.println(++lastMissingIndex);
	        }
	 
	    }




	public static void main(String[] args) {
		// one missing number
        printMissingNumber(new int[]{1, 2, 3, 4, 6}, 6);
 
        // two missing number
        printMissingNumber(new int[]{1, 2, 3, 4, 6, 7, 9, 8, 10}, 10);
 
        // three missing number
        printMissingNumber(new int[]{1, 2, 3, 4, 6, 9, 8}, 10);
 
        // four missing number
        printMissingNumber(new int[]{1, 2, 3, 4, 9, 8}, 10);



	}
}
