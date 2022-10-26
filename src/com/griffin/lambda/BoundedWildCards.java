package com.griffin.lambda;

import java.util.Arrays;
import java.util.List;

public class BoundedWildCards {

	/*
	Demonstrate use of upper bounded and lower bounded custom classes.
	 */
	public static void main(String... args) {

		List<Engineer> validUpperBound = Arrays.asList(new Engineer(), new FirmwareEngineer());
		printBounded1(validUpperBound);

		// Note that Person is a superclass of Employee, so printBounded2 accepts it.
		List<Person> validLowerBound = Arrays.asList(new Employee(), new Person());
		printBounded2(validLowerBound);
		List<Employee> validLowerBound2 = Arrays.asList(new Employee());
		printBounded2(validLowerBound2);

		// Note that an Engineer IS A Employee, so this works too!! Makes you question the usefulness of Lower Bound?
		List<? super Employee> validLowerBound3 = Arrays.asList(new Engineer(), new Employee(), new Person());
		printBounded2(validLowerBound3);

		// ...however, can't supply a typed Engineer List.
		List<Engineer> validLowerBound4 = Arrays.asList(new Engineer());
//        printBounded2(validLowerBound4);    // Compile-time error: List<Engineer> not acceptable as List<? super Employee>


	}

	public static void printBounded1(List<? extends Engineer> engineers) {      // Upper bound: Engineer, FirmwareEng
		engineers.forEach(System.out::println);
	}

	public static void printBounded2(List<? super Employee> employees) {      // Lower bound: Employee,Person
		employees.forEach(System.out::println);
	}

	public static class Person {
	}

	public static class Employee extends Person {
	}

	public static class Engineer extends Employee {
	}

	public static class FirmwareEngineer extends Engineer {

	}
}
