package com.griffin.lambda;

import java.util.*;

public class SetSorts {
    /*
    Demonstrate how to sort a Set containing custom objects.
    1) Use Comparable implementation
     */

	public static void main(String... args) {

		EntityWrapper entityWrapper1 = new EntityWrapper(1, "One");
		EntityWrapper entityWrapper2 = new EntityWrapper(2, "Two");
		EntityWrapper entityWrapper3 = new EntityWrapper(3, "Three");
		EntityWrapper entityWrapper4 = new EntityWrapper(0, "Four");

		List<EntityWrapper> entityWrappers = Arrays.asList(entityWrapper1, entityWrapper3, entityWrapper2);
		Set<EntityWrapper> entityWrapperSet = new TreeSet<>(entityWrappers);

		// Natural sort
		entityWrapperSet.stream().forEach(System.out::println);

		// Add another EntityWrapper object to demonstrate implicit sorting via Comparable impl
		entityWrapperSet.add(entityWrapper4);
		entityWrapperSet.stream().forEach(System.out::println);

	}

	public static class EntityWrapper implements Comparable<EntityWrapper> {
		Integer ID;

		String name;

		public EntityWrapper(Integer ID, String name) {
			this.ID = ID;
			this.name = name;
		}

		@Override
		public int compareTo(EntityWrapper o) {
			return (this.ID.compareTo(o.ID));
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
