package com.sci.tutoriales;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamsT {

	/**
	 * A Stream in Java is a sequence of elements supporting parallel and aggregate
	 * operations. This sequence of elements are obtained from a source.
	 * 
	 * @param args
	 */
	static List<Employee> employeeList = Arrays.asList(new Employee("Tom Jones", 45), new Employee("Harry Major", 25),
			new Employee("Ethan Hardy", 65), new Employee("Nancy Smith", 15), new Employee("Deborah Sprightly", 29),
			new Employee("Dick Hiddleton Sprightly", 44), new Employee("Alexander Hick", 19),
			new Employee("Harry Major", 25), new Employee("Nancy Smith", 15));

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> filteredList = employeeList.stream().limit(3).collect(toList());
		filteredList.forEach(System.out::println);

		// Lazy execution of Streams and opportunity for optimizations
		Stream.iterate(0, n -> n + 2).peek(num -> System.out.println("Peeked at:" + num)).limit(5)
				.forEach(System.out::println);

		/**
		 * he map() method helps us transform one type of stream to another type of
		 * stream. Definition of map() method in java.util.stream.Stream<T> is –
		 * 
		 * <R> Stream<R> map(Function<? super T,? extends R> mapper) Where,
		 * 
		 * map() method takes as input an instance of Function <T, R> which converts the
		 * type of elements in the stream from the current type T to the new type R. It
		 * returns as output a stream of type R or Stream<R>
		 * 
		 */
		// Definition & usage of map() method
		List<String> mappedList = employeeList.stream().map(emp -> emp.getName()).collect(toList());
		mappedList.forEach(System.out::println);

		// Definition & usage of flatMap() method
		List<String> nameCharList = employeeList.stream().map(emp -> emp.getName().split(""))
				.flatMap(array -> Arrays.stream(array)).map(str -> str.toUpperCase()).filter(str -> !(str.equals(" ")))
				.collect(toList());
		nameCharList.forEach(str -> System.out.print(str));

		// Java example demonstrating the use of filter, distinct, limit & skip methods
		filteredList = employeeList.stream().filter((Employee e) -> e.getAge() > 24).collect(toList());
		System.out.println("After applying filter method");
		filteredList.forEach(System.out::println);
		// distinct method
		filteredList = filteredList.stream().distinct().collect(toList());
		System.out.println("After applying distinct() method");
		filteredList.forEach(System.out::println);
		// limit method
		filteredList = filteredList.stream().limit(2).collect(toList());
		System.out.println("After applying limit(2) method");
		filteredList.forEach(System.out::println);
		// skip method
		filteredList = filteredList.stream().skip(1).collect(toList());
		System.out.println("After applying skip(1) method");
		filteredList.forEach(System.out::println);

		// Stream.allMatch() method
		boolean allEmpAbove21 = employeeList.stream().allMatch(emp -> emp.getAge() > 21);
		System.out.println("All employees are above 21:" + allEmpAbove21);

		boolean empAbove40 = employeeList.stream().anyMatch(emp -> emp.getAge() > 40);
		System.out.println("Any employee is above 40:" + empAbove40);

		boolean noEmpBelow30 = employeeList.stream().noneMatch(emp -> emp.getAge() < 30);
		System.out.println("No employee is below 30:" + noEmpBelow30);

		// Stream.findAny() .findFirst()
		Optional<Employee> anyEmpAbove40 = employeeList.stream().filter(emp -> emp.getAge() > 40).skip(1).findAny();
		if (anyEmpAbove40.isPresent()) {
			System.out.println("Any Employee above age 40: " + anyEmpAbove40.get());
		}

		Optional<Employee> firstEmpBelow30 = employeeList.stream().filter(emp -> emp.getAge() < 30).findFirst();
		if (firstEmpBelow30.isPresent()) {
			System.out.println("First employee below 30: " + firstEmpBelow30.get());
		}

		// Stream.peek()
		Stream.iterate(1, (Integer n) -> n + 1).peek(n -> System.out.println("number generated: - " + n))
				.filter(n -> (n % 2 == 0)).peek(n -> System.out.println("Even number filter passed for - " + n))
				.limit(5).count();

		/**
		 * Creating infinite Streams using the Stream.iterate() method Let us start by
		 * looking at the signature of Stream.iterate() method –
		 * 
		 * static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
		 */
		// Stream.iterate()
		Stream.iterate(2, (Integer n) -> n * n).limit(5).forEach(System.out::println);

		// Stream.generate()
		Stream.generate(Math::random).limit(5).forEach(System.out::println);

		
		// Stream.reduce()
		employeeList = Arrays.asList(new Employee("Tom Jones", 45, 7000.00), new Employee("Harry Major", 25, 10000.00),
				new Employee("Ethan Hardy", 65, 8000.00), new Employee("Nancy Smith", 22, 12000.00),
				new Employee("Deborah Sprightly", 29, 9000.00));

		Double totalSalaryExpense = employeeList.stream().map(emp -> emp.getSalary()).reduce(0.00, (a, b) -> a + b);
		System.out.println("Total salary expense: " + totalSalaryExpense);

		Optional<Employee> maxSalaryEmp = employeeList.stream()
				.reduce((Employee a, Employee b) -> a.getSalary() < b.getSalary() ? b : a);
		if (maxSalaryEmp.isPresent())
			System.out.println("Employee with max salary: " + maxSalaryEmp.get());

		
	}

}
