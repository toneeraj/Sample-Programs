package com.maps;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner (System.in);
        int numOfTestCases = Integer.parseInt(scanner.nextLine());
        
        
        //Read name and phone number in a map
        
        Map<String, Integer> namePhone = new HashMap<>();
        for (int i=0; i< numOfTestCases; i++) {
            String name = scanner.nextLine();
            int phone = Integer.parseInt(scanner.nextLine());
            namePhone.put(name , phone);
        }
        
        for (int j=0; j< numOfTestCases; j++) {
            String testInputName = scanner.nextLine();
            if (namePhone.containsKey(testInputName)) {
                System.out.println(testInputName+"="+namePhone.get(testInputName));
            } else {
                System.out.println("Not found");
            }
        }
       

    }
}
