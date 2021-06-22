package com.tcs.divisiblecheck;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * DivisibleByIntegerTest
 * 
 * @author Ramesh
 *
 */
class DivisibleByIntegerTest {

	/**
	 * Method to perfom list of int divisible by 5 getDivisibleByIntegerTest
	 * 
	 */
	@Test
	public void getDivisibleByIntegerTest() {
		List<Integer> listData = DivisibleByInteger.getMockData();
		DivisibleByInteger divByInteger = new DivisibleByInteger();
		int val = 5;
		int val1 = 15;
		int val2 = 11;
		assertTrue(divByInteger.getDivisibleByInt(listData, val).stream().anyMatch(x -> x == val));
		assertTrue(divByInteger.getDivisibleByInt(listData, val).stream().anyMatch(x -> x == val1));
		assertFalse(divByInteger.getDivisibleByInt(listData, val).stream().anyMatch(x -> x == val2));
	}

}
