package com.tcs.divisiblecheck;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DivisibleByInteger
 * 
 * @author Ramesh
 *
 */
public class DivisibleByInteger {

	/**
	 * 
	 * @param list
	 * @param div
	 * @return
	 */
	public List<Integer> getDivisibleByInt(List<Integer> list, int div) {

		List<Integer> retVal = (List<Integer>) list.stream().filter(gen -> gen % div == 0).collect(Collectors.toList());
		return retVal;

	}

	/**
	 * Mock Data
	 * 
	 * @return List<Integer>
	 */
	public static List<Integer> getMockData() {

		List<Integer> listData = new ArrayList<Integer>();

		listData.add(1);
		listData.add(3);
		listData.add(5);
		listData.add(7);
		listData.add(11);
		listData.add(15);
		listData.add(29);

		return listData;
	}

	public static void main(String args[]) {
		// List<Integer> list=Arrays.asList(1,2,3);
		DivisibleByInteger dbi = new DivisibleByInteger();
		int val = 5;
		System.out.println(dbi.getDivisibleByInt(getMockData(), val));

	}

}
