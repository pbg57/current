package com.griffin.lambda;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;

public class CompareSets {
	/*
	You are given a dictionary of words and a large input string. You have to find out whether the  words in the string can be found in the dictionary?
	 */
	public static void main(String... args) {

		String dict = " You are given a dictionary of words and a large input string. You have to find out whether the  words in the string can be found in the dictionary";
		String testString = "You are given a dictionary of words and a large bogus input";

		String[] dictSplit = dict.split(" ");
		String[] testSplit = testString.split(" ");

		Set<String> dictionarySet = new TreeSet<>(Arrays.asList(dictSplit));

		Predicate<String> IS_IN_DICTIONARY = dictionarySet::contains;

		long notfoundcount = Arrays.stream(testSplit).filter(IS_IN_DICTIONARY.negate()).count();


		System.out.println("Number missing words: " + notfoundcount);

	}
}
