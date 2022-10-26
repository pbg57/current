package com.griffin.lambda;

import java.util.Arrays;
import java.util.List;

public class ArraySort {
	/*
    Demonstrate how to sort an Array containing primitives and custom objects.
    1) Use Comparable implementation
     */

	public static void main(String... args) {

		List<Entity> entities = Arrays.asList(
				new Entity(1, "one"),
				new Entity(3, "three"),
				new Entity(2, "two"),
				new Entity(4, "four")
		);


		// Primitives
		int[] intArray = { 4, 2, 6, 8, 2, 1 };
		Arrays.stream(intArray).forEach(System.out::println);
		Arrays.sort(intArray);
		Arrays.stream(intArray).forEach(System.out::println);

		// custom objects
		Entity[] entities1 = entities.toArray(new Entity[0]);
		Arrays.stream(entities1).forEach(System.out::println);
		Arrays.sort(entities1);
		Arrays.stream(entities1).forEach(System.out::println);

	}

	public static class Entity implements Comparable<Entity> {
		Integer ID;

		String entityName;

		public Entity(Integer ID, String entityName) {
			this.ID = ID;
			this.entityName = entityName;
		}

		@Override
		public int compareTo(Entity o) {
			return (this.ID.compareTo(o.ID));
		}

		@Override
		public String toString() {
			return "Entity{" +
					"ID=" + ID +
					", entityName='" + entityName + '\'' +
					'}';
		}
	}
}
