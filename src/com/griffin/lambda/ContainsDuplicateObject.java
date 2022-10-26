package com.griffin.lambda;

import java.util.*;
import java.util.function.Predicate;

public class ContainsDuplicateObject {
    /*
    Given a single List of objects, determine if there are any duplicate entries in the List?
    Use simple Integer List and custom class List.
     */


	public static void main(String... args) {

		List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 5, 6, 8, 3, 3);

		// Use Collections for efficiency.
		Predicate<Integer> INT_OCCURS_GT1X = (i) -> (Collections.frequency(integerList, i) > 1);
		List<Integer> duplicates = integerList.stream().filter(INT_OCCURS_GT1X).distinct().toList();

		duplicates.forEach(System.out::println);

		List<Entity> entities = Arrays.asList(
				new Entity(1),
				new Entity(2),
				new Entity(3),
				new Entity(2)
		);

		// Note Entity class requires override impl of equals()
		Predicate<Entity> DUPLICATE_ENTITY = (ent) -> (Collections.frequency(entities, ent) > 1);
		List<Entity> duplicates2 = entities.stream().filter(DUPLICATE_ENTITY).distinct().toList();
		duplicates2.forEach(System.out::println);
	}

	public static class Entity {
		Integer ID;

		Entity(Integer ID) {
			this.ID = ID;
		}

		@Override
		public String toString() {
			return "Entity{" +
					"ID=" + ID +
					'}';
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Entity entity = (Entity) o;
			return Objects.equals(ID, entity.ID);
		}

		@Override
		public int hashCode() {
			return Objects.hash(ID);
		}
	}
}
