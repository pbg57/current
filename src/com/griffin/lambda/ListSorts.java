package com.griffin.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ListSorts {
	/*
	Demonstrate how to sort a List containing custom objects.
	1) Use Comparable implementation (imposes class's natural order)
	Note: It is strongly recommended (though not required) that natural orderings be consistent with equals.
	Note: Virtually all Java core classes that implement Comparable have natural orderings that are consistent with equals.
	2) Use custom Comparator
	 */
	public static void main(String... args) {

		EntityWrapper entityWrapper1 = new EntityWrapper(1, "One");
		EntityWrapper entityWrapper2 = new EntityWrapper(2, "Two");
		EntityWrapper entityWrapper3 = new EntityWrapper(3, "Three");

		List<EntityWrapper> entityWrappers = Arrays.asList(entityWrapper1, entityWrapper3, entityWrapper2);

		// Pre sort() : not sorted. List ordering same as array.
		entityWrappers.stream().forEach(System.out::println);

		// Sort with null argument uses natural ordering (Comparable) of class
		entityWrappers.sort(null);
		entityWrappers.stream().forEach(System.out::println);

		// Override class natural sort with Comparator
		Comparator<EntityWrapper> EWNAMESORT = (ew1, ew2) -> ew1.name.compareTo(ew2.name);
		entityWrappers.sort(EWNAMESORT);
		entityWrappers.stream().forEach(System.out::println);

	}

	public static class EntityWrapper implements Comparable<EntityWrapper> {
		Integer ID;

		String name;

		EntityWrapper(Integer ID, String name) {
			this.ID = ID;
			this.name = name;
		}

		@Override
		public int compareTo(EntityWrapper o) {
			return this.ID.compareTo(o.ID);
		}

		@Override
		public String toString() {
			return "EntityWrapper{" +
					"ID=" + ID +
					", name='" + name + '\'' +
					'}';
		}
	}
}
