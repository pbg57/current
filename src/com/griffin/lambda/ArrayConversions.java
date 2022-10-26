package com.griffin.lambda;

import java.util.Arrays;
import java.util.List;

public class ArrayConversions {
    /*
    Convert between arrays and lists for objects and primitives
     */

	public static void main(String... args) {

		int[] ints = { 1, 2, 3, 4 };
		Integer[] integers = { 5, 6, 7, 8 };

		// Arrays to Lists
		List<Integer> integerList = Arrays.stream(ints).boxed().toList();
		List<Integer> integerList1 = Arrays.asList(integers);


		integerList.stream().forEach(System.out::println);
		integerList1.stream().forEach(System.out::println);

		// Lists to Arrays
		Integer[] fromList = integerList.toArray(new Integer[0]);

		int[] fromList1 = new int[integerList1.size()];
		for (int i = 0; i < integerList1.size(); i++) {
			fromList1[i] = integerList1.get(i);
		}

		Arrays.stream(fromList).forEach(System.out::println);
		Arrays.stream(fromList1).forEach(System.out::println);
	}
}
