package com.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Your program is to use the brute-force approach in order to find the Answer
 * to Life, the Universe, and Everything. More precisely... rewrite small
 * numbers from input to output. Stop processing input after reading in the
 * number 42. All numbers at input are integers of one or two digits.
 * 
 * http://www.spoj.com/problems/TEST/
 * 
 * Input: 1 2 88 42 99
 * 
 * Output: 1 2 88
 * 
 * @author neerajsingh
 *
 */
public class PrintInput {
	public static void main(String[] args) throws Exception {
		
		
		List<Integer> list = new ArrayList<>();
		while (true) {
			
			Scanner in = new Scanner(System.in);
			int value = in.nextInt();
			
			

			if (value == 45) {
				break;
			} else {
				list.add(value);
			}
			
			
		}
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}


	}
}
