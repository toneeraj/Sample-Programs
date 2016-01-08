package com.test.test;

public class General {
	public static void main(String[] args) {

		Object obj = null;
		
		String s = String.valueOf(obj);
		
		System.out.println(s);
		
		if (s == null) {
			System.out.println("True yes s is null..." + s);
		} else if (s.equalsIgnoreCase("null")) {
			System.out.println("Nope s is not null..." + s);
		} 
		
		if (s == "null") {
			System.out.println("testing for code success");
		}
	}
}
