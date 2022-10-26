package com.griffin.lambda;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SetSecondarySorting {
	/*
    You are given lists of data containing a Date and Name. Create the ability to
    sort lists by date, and then Name.
     */
	public static void main(String... args) {

		// Define comparators for custom sorting.
		Comparator<EntityWrapper> SORTBYDATE = (ew1, ew2) -> ew1.localDate.compareTo(ew2.localDate);
		Comparator<EntityWrapper> SORTBYNAME = (ew1, ew2) -> ew1.name.compareTo(ew2.name);

		EntityWrapper entityWrapper1 = new EntityWrapper(LocalDate.of(2022, Month.DECEMBER, 25), "Phil Griffin");
		EntityWrapper entityWrapper2 = new EntityWrapper(LocalDate.of(2022, Month.DECEMBER, 25), "Dylan Griffin");
		EntityWrapper entityWrapper3 = new EntityWrapper(LocalDate.of(2022, Month.DECEMBER, 23), "Dylan Griffin");


		List<EntityWrapper> entityWrappers = Arrays.asList(entityWrapper1, entityWrapper2, entityWrapper3);

		entityWrappers.forEach((System.out::println));
		entityWrappers.sort(SORTBYDATE.reversed());
		entityWrappers.forEach((System.out::println));

		// Note use of Comparator interface for secondary sorting.
		entityWrappers.sort(SORTBYDATE.thenComparing(SORTBYNAME));
		entityWrappers.forEach((System.out::println));

	}

	public static class EntityWrapper {
		LocalDate localDate;

		String name;

		public EntityWrapper(LocalDate localDate, String name) {
			this.localDate = localDate;
			this.name = name;
		}

		@Override
		public String toString() {
			return "EntityWrapper{" +
					"localDate=" + localDate +
					", name='" + name + '\'' +
					'}';
		}
	}
}
