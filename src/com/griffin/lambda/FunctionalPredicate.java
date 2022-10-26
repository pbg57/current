package com.griffin.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FunctionalPredicate {
	/*
    Write a generic method that accepts a list of strings and a java.util.function.Predicate to produce a result List.
    1) Use a Predicate interface impl via Anonymous class declaration, and 2) a lambda expression
 	*/

	public static void main(String... args) {

		List<String> strings = Arrays.asList("One", "Two", "Three");

		// Predicate impl with lambda.
		Predicate<String> CONTAINSE = (s) -> s.contains("e");
		List<String> result = evaluateList(strings, CONTAINSE);
		result.forEach(System.out::println);

		// Predicate impl using anonymous class impl.
		List<String> result2 = evaluateList(strings, new SimplePredicate());
		result2.forEach(System.out::println);

	}

	public static class SimplePredicate implements Predicate<String> {
		public boolean test(String string) {
			return (string.contains("e"));
		}
	}

	public static List<String> evaluateList(List<String> strings, Predicate<String> pred) {

		List<String> results = new ArrayList<>();
		Consumer<String> ADDTOLIST = results::add;
		Consumer<String> PRINTCFM = (s) -> {
			System.out.println("Added Name: " + s);
		};
		strings.stream().filter(pred).forEach(ADDTOLIST.andThen(PRINTCFM));
		return results;

	}
}
