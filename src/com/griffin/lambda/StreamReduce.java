package com.griffin.lambda;

import java.util.Arrays;

public class StreamReduce {
    /* Various Java 8 Stream reduce examples:
        Stream.java method:
            identity == default or initial value
            BinaryOperator = functional interface, take two values and produces a new value.
        T reduce(T identity, BinaryOperator<T> accumulator);

        Optional<T> reduce(BinaryOperator<T> accumulator);
        if the identity argument is missing, there is no default or initial value, and it returns an optional.
     */

	public static void main(String... args) {

		// Note: you must use java's IntPredicate when using int[] (or box the stream)

		Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		// Sum the numbers array using stream().reduce() using a) lambda expression, b) Integer method format
		int sum = Arrays.stream(numbers).reduce(0, (i1, i2) -> i1 + i2);
		sum = Arrays.stream(numbers).reduce(0, Integer::sum);
		System.out.println("Sum: " + sum);


		// Find the maximum value in the numbers array using stream().reduce()
		int max = Arrays.stream(numbers).reduce(numbers[0], Integer::max);
		System.out.println("Max: " + max);

		// Find the minimum value in the numbers array using stream().reduce()
		//Note lambda expression fulfils BinaryOperator interface.
		int min = Arrays.stream(numbers).reduce(numbers[0], (i1, i2) -> i1 < i2 ? i1 : i2);
		System.out.println("min: " + min);

		// Sum only the odd numbers in the array using stream().reduce()
		//Note lambda expression fulfils BinaryOperator interface.
		int odd = Arrays.stream(numbers).reduce(0, (i1, i2) -> i2 % 2 != 0 ? i1 + i2 : i1);
		System.out.println("odd: " + odd);

	}
}
