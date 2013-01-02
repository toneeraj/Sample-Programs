package com.test;

import java.util.List;


public class TestImpl implements TestInterface {

	List<java.lang.Integer> myList;

	public void setMyList(List<Integer> myList) {
		this.myList = myList;
	}

	public void print() {
		for (int i : myList) {
			System.out.println(i);
		}
	}


}