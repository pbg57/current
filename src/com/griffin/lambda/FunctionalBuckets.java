package com.griffin.lambda;

import java.util.Arrays;
import java.util.function.Predicate;

public class FunctionalBuckets {
	/*
    Given a stream of Integers, process the stream to determine buckets: integers < 100; integers > 100; integers >= 100
     */
	public static void main(String... args) {

		Integer[] integers = { 1, 44, 50, 55, 100, 111, 1111 };

		Predicate<Integer> LESSTHAN100 = (i) -> i < 100;
		Predicate<Integer> GREATERTHANEQ100 = (i) -> i >= 100;

		long lessThan = Arrays.stream(integers).filter(LESSTHAN100).count();
		long greaterThan = Arrays.stream(integers).filter(GREATERTHANEQ100).count();

		System.out.println("LT: " + lessThan + " GTE: " + greaterThan);
	}
}
