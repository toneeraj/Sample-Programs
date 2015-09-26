package com.programming;

import java.util.*;


/**
 * One liner clever solution //http://www.codewars.com/kata/53e30ec0116393fe1a00060b/solutions/java/all/best_practices
 * 
 *  return Arrays.stream(integers).distinct().toArray();
 *  
 *  --------------
 *  
 *  
 *  ArrayList<Integer> list = new ArrayList<>();
    for(int i : integers) {
      if(!list.contains(i)) {list.add(i);}
    }
    int[] out = new int[list.size()];
    int count = 0;
    for(Integer i : list) {
      out[count++] = i;
    }
    return out;
    
    -----------
    Set<Integer> set = new LinkedHashSet<Integer>();
    for(int i: integers){
      set.add(i);
    }
    return set.stream().mapToInt(i->i).toArray();
  }
  
 * @author neerajsingh
 *
 */

public class UniqueArray {
  public static int[] unique(int[] integers) {

		if (null == integers) {
    	return new int[0];
    }
    
    if (integers.length == 0 ) {
    	return new int[0];
    }
    
    if (integers.length == 1) {
    	return integers;
    }


    //find the mimimum number and note if it is negative
    //array containing negative number need to be handled differently
    int theSmallest = 0;
    int theLargest = 0;
    for (int i = 0; i< integers.length; i++) {
      
      if (integers[i] < theSmallest) {
        theSmallest = integers[i];     
      } else if (integers[i] > theLargest) {
      	theLargest = integers[i];
      }
      
    }
    
    //Yes the array has the smallest as the negative number
    //Let us make the entire array as positive by adding theSmallest to all the numbers
    //This will be reverted back to get the original numbers
    if (theSmallest < 0) {
      for (int i=0; i<integers.length; i++) {
        integers[i] = integers[i] + java.lang.Math.abs(theSmallest);    
      }
    }
    
    
    //will create a BitSet and will flag the index corresponding to values in the given array (or modified in case of negative)
    //if it is not already set. But if it is set that means the element is already present, so it will be ignored as the corresponding bit is already set
    BitSet bitSet = new BitSet(theLargest + java.lang.Math.abs(theSmallest));
    int duplicateCount = 0;
    ArrayList<Integer> outputValues = new ArrayList<Integer>();
    int outputIndex = 0;
    for (int i=0; i<integers.length; i++) {
        
        if (bitSet.get(integers[i]) == true) {
        //duplicate found
        duplicateCount++;
        } else {
        	bitSet.set(integers[i]);
        	outputValues.add(outputIndex++, integers[i]);
        }
        
    }
    
    //Let us create the output array. The size of this array will be size of orignal array less duplicateCount
    int[] outputArray = new int[integers.length - duplicateCount];

  //Populate the output array. This is done by copying the values from the BitSet which corresponds to the set value
    for (int i=0; i< outputValues.size(); i++) {
    	outputArray[i] =  outputValues.get(i);
    }
   
    //if the smallest number was negative, let us bring back the original value in the output array by subtracting theSmallest from each value
    if (theSmallest < 0) {
	    for (int i=0 ; i<outputArray.length; i++) {
    		outputArray[i] = outputArray[i] - java.lang.Math.abs(theSmallest);
    	}
    }
    return outputArray;
    
  }
}
