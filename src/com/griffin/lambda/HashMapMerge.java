package com.griffin.lambda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class HashMapMerge {
	/*
    Write a class that accepts a sentence or string of words and determines how many instances of each unique word occurs?
     */

	public static void main(String... arg) {

		String dictionaryInput = "Write a class that accepts a sentence or string of words and determines how many instances of each unique word occurs";
		String[] inputSplit = dictionaryInput.split(" ");

		// Use HashMap, keyed by word and where value is word count.
		Map<String, Integer> dictionaryMap = new HashMap<>();

		// merge() operation:
		// If key is new, or is mapped to a null value, key's value will be set to '1'.
		// Otherwise, key value is remapped to current value plus '1'.
		Consumer<String> MERGEVALUE = (s) -> dictionaryMap.merge(s, 1, Integer::sum);

		Arrays.stream(inputSplit).forEach(MERGEVALUE);

		Consumer<String> DISPLAYMAPENTRY = (s) -> {
			System.out.println("Key: " + s + " Value: " + dictionaryMap.get(s));
		};

		dictionaryMap.keySet().forEach(DISPLAYMAPENTRY);
	}
}
