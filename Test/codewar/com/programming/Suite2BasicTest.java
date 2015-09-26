package com.programming;

import static org.junit.Assert.*;
import org.junit.Test;

public class Suite2BasicTest {

	@Test
	public void test1() {
		assertEquals("[0]", Suite2Basic.game(0));
	}

	@Test
	public void test2() {
		assertEquals("[1, 2]", Suite2Basic.game(1));
	}

	@Test
	public void test3() {
		assertEquals("[32]", Suite2Basic.game(8));
	}
	
	@Test
	public void test4() {
		assertEquals("[10201, 2]", Suite2Basic.game(101));
	}
	
	@Test
	public void test5() {
		assertEquals("[10201, 2]", Suite2Basic.game(750000));
	}

}
