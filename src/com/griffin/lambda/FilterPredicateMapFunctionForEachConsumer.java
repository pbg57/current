package com.griffin.lambda;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FilterPredicateMapFunctionForEachConsumer {
       /*
        Write a class that filters a stream for >=18 yr old males, maps their birthdate, and adds them to a List.
        Take advantage of filter(Predicate), map(Function), forEach(Consumer) stream processing.
     */

	public static void main(String... args) {
		EntityWrapper entityWrapper1 = new EntityWrapper(LocalDate.of(2014, Month.JULY, 22), 'M');
		EntityWrapper entityWrapper2 = new EntityWrapper(LocalDate.of(2004, Month.JULY, 22), 'M');
		EntityWrapper entityWrapper3 = new EntityWrapper(LocalDate.of(2003, Month.JULY, 23), 'M');
		EntityWrapper entityWrapper4 = new EntityWrapper(LocalDate.of(2000, Month.JULY, 22), 'F');

		List<EntityWrapper> entityWrappers = Arrays.asList(entityWrapper1, entityWrapper2, entityWrapper3, entityWrapper4);

		// Predicate to filter for >=18-year-old males.
		Predicate<EntityWrapper> AGE_18_MALE = (ew) -> {
			return (ew.sex == 'M') &&
					(Period.between(ew.birthday, LocalDate.now()).getYears() >= 18);
		};

		List<LocalDate> birthdayList = new ArrayList<>();

		// Function to map a birthday for an EntityWrapper object.
		Function<EntityWrapper, LocalDate> MAP_BIRTHDAY = (ew) -> ew.birthday;

		// Consumer will add qualifying birthdays to a new list.
		Consumer<LocalDate> ADD_BIRTHDAY = birthdayList::add;

		entityWrappers.stream().filter(AGE_18_MALE).map(MAP_BIRTHDAY).forEach(ADD_BIRTHDAY);

		birthdayList.forEach(System.out::println);
	}

	public static class EntityWrapper {
		LocalDate birthday;

		Character sex;

		public EntityWrapper(LocalDate birthday, Character sex) {
			this.birthday = birthday;
			this.sex = sex;
		}

		@Override
		public String toString() {
			return "EntityWrapper{" +
					"localDate=" + birthday +
					", sex=" + sex +
					'}';
		}
	}
}
