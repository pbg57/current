package com.griffin.lambda;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MissingDataSubSets {
	/*
    You are given sets of data containing a Date, Name, and Sex. Create a method to
    create unique, sets for entries missing Name or Sex values for post-processing
     */

	public static void main(String... args) {

		DataSet dataSet1 = new DataSet(LocalDate.of(2022, Month.DECEMBER, 25), "Phil", 'M');
		DataSet dataSet2 = new DataSet(LocalDate.of(2022, Month.NOVEMBER, 25), "", 'M');
		DataSet dataSet3 = new DataSet(LocalDate.of(2021, Month.JANUARY, 25), "Phil", null);

		List<DataSet> dataSets = Arrays.asList(dataSet3, dataSet1, dataSet2);

		// Predicates to find items with missing values (name, sex)
		Predicate<DataSet> MISSING_NAME = (ds) -> ds.name == null || ds.name.length() == 0;
		Predicate<DataSet> MISSING_SEX = (ds) -> ds.sex == null;

		Set<DataSet> missingNameSet = dataSets.stream().filter(MISSING_NAME).collect(Collectors.toSet());
		Set<DataSet> missingSexSet = dataSets.stream().filter(MISSING_SEX).collect(Collectors.toSet());

		missingSexSet.forEach(System.out::println);
		missingNameSet.forEach(System.out::println);

	}

	public static class DataSet {
		LocalDate localDate;

		String name;

		Character sex;

		DataSet(LocalDate ld, String name, Character sex) {
			this.localDate = ld;
			this.name = name;
			this.sex = sex;
		}

		@Override
		public String toString() {
			return "DataSet{" +
					"localDate=" + localDate +
					", name='" + name + '\'' +
					", sex=" + sex +
					'}';
		}
	}
}
