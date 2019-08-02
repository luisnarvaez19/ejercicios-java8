package com.sci.tutoriales;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * In Java 8 a Function Descriptor is a term used to describe the signature of
 * the abstract method of a Functional Interface . The signature of the abstract
 * method of a Functional Interface is syntactically the same as the signature
 * of the Lambda Expression . Hence, a Function Descriptor also describes the
 * signature of a lambda.
 * 
 * @FunctionalInterface public interface FirstInterface { //Single abstract
 *                      method public void singleMethod(String param); } For the
 *                      above interface, named FirstInterface, the signature of
 *                      the abstract method OR the function descriptor is
 *                      (String) -> void
 * 
 * @FunctionalInterface public interface SecondInterface { //Single abstract
 *                      method public long computeSum(int num1, int num2); } For
 *                      SecondInterface the function descriptor is (int,int) ->
 *                      long
 * @author luis
 *
 */
public class FunctionalInterfacesT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**
		 * What is java.util.function.Predicate – Predicate is a new functional
		 * interface defined in java.util.function package which can be used in all the
		 * contexts where an object needs to be evaluated for a given test condition and
		 * a boolean value needs to be returned based on whether the condition was
		 * successfully met or not. boolean test(T t) is the abstract method which will
		 * define the signature of the lambda expression/method reference which can be
		 * assigned to a target of type Predicate.
		 */
		// Example of using Predicate for a boolean condition check –
		Predicate<Integer> positive = i -> i > 0;
		List<Integer> integerList = Arrays.asList(new Integer(1), new Integer(10), new Integer(200), new Integer(101),
				new Integer(-10), new Integer(0));
		List<Integer> filteredList = filterList(integerList, positive);
		Predicate<Integer> otro = (i -> i > 101);
		filteredList = filterList(integerList, positive.and(otro));
		filteredList.forEach(System.out::println);

		// Predicate in Collection
		List<User> users = new ArrayList<User>();
		users.add(new User("John", "admin"));
		users.add(new User("Peter", "member"));
		List<User> admins = User.process(users, (User u) -> u.getRole().equals("admin"));
		System.out.println(admins);

		/**
		 * Consumer can be used in all contexts where an object needs to be
		 * consumed,i.e. taken as input, and some operation is to be performed on the
		 * object without returning any result. Since Consumer is a functional
		 * interface, hence it can be used as the assignment target for a lambda
		 * expression or a method reference. Consumer’s Function Descriptor is T -> ()
		 * accept() method is the primary abstract method of the Consumer functional
		 * interface. andThen() is a default method in Consumer interface.
		 */
		// Usage of accept() method of Consumer:

		Consumer<Integer> consumer = i -> System.out.print(" " + i);
		printList(integerList, consumer);

		// Usage of default method andThen() of Consumer
		Consumer<Integer> consumerWithAndThen = consumer.andThen(i -> System.out.print("(printed " + i + ")"));
		printList(integerList, consumerWithAndThen);

		/**
		 * Supplier can be used in all contexts where there is no input but an output is
		 * expected. Since Supplier is a functional interface, hence it can be used as
		 * the assignment target for a lambda expression or a method reference.
		 * Supplier’s Function Descriptor is () -> T . get() method is the primary
		 * abstract method of the Supplier get() method is the primary abstract method
		 * of the Supplier functional interface.
		 */
		// Supplier instance with lambda expression
		Supplier<String> helloStrSupplier = () -> new String("Hello");
		String helloStr = helloStrSupplier.get();
		System.out.println("\nString in helloStr is->" + helloStr + "<-");

		// Supplier instance using method reference to default constructor
		Supplier<String> emptyStrSupplier = String::new;
		String emptyStr = emptyStrSupplier.get();
		System.out.println("String in emptyStr is->" + emptyStr + "<-");

		// Supplier instance using method reference to a static method
		Supplier<Date> dateSupplier = FunctionalInterfacesT::getSystemDate;
		Date systemDate = dateSupplier.get();
		System.out.println("systemDate->" + systemDate);

		/**
		 * Function<T, R> is an in-built functional interface introduced in Java 8 in
		 * the java.util.function package. The primary purpose for which Function<T, R>
		 * has been created is for mapping scenarios i.e when an object of a type is
		 * taken as input and it is converted(or mapped) to another type. Function<T,
		 * R>’s Function Descriptor is T -> R. Method apply() is the primary abstract
		 * functional method of Function interface
		 * 
		 */
		// Usage of apply() method of Function
		Function<Employee, String> funcEmpToString = (Employee e) -> {
			return e.getName();
		};
		List<Employee> employeeList = Arrays.asList(new Employee("Tom Jones", 45), new Employee("Harry Major", 25),
				new Employee("Ethan Hardy", 65), new Employee("Nancy Smith", 15),
				new Employee("Deborah Sprightly", 29));
		List<String> empNameList = convertEmpListToNamesList(employeeList, funcEmpToString);
		empNameList.forEach(System.out::println);

		// Usage of default method andThen() of Function
		Function<String, String> initialFunction = (String s) -> s.substring(0, 1);
		List<String> empNameListInitials = convertEmpListToNamesList(employeeList,
				funcEmpToString.andThen(initialFunction));
		empNameListInitials.forEach(str -> {
			System.out.print(" " + str);
		});

		// Usage of default method compose() of Function
		Function<Employee, Employee> funcEmpFirstName = (Employee e) -> {
			int index = e.getName().indexOf(" ");
			String firstName = e.getName().substring(0, index);
			e.setName(firstName);
			return e;
		};
		List<String> empFirstNameList = convertEmpListToNamesList(employeeList,
				funcEmpToString.compose(funcEmpFirstName));
		empFirstNameList.forEach(str -> {
			System.out.print(" " + str);
		});

		// Usage of static method identity() of Function
		List<Employee> empNameListInitialsE = applyIdentityToEmpList(employeeList, Function.identity());
		empNameListInitialsE.forEach(System.out::println);
	}

	public static List<Integer> filterList(List<Integer> listOfIntegers, Predicate<Integer> predicate) {
		List<Integer> filteredList = new ArrayList<Integer>();
		for (Integer integer : listOfIntegers) {
			if (predicate.test(integer)) {
				filteredList.add(integer);
			}
		}
		return filteredList;
	}

	public static void printList(List<Integer> listOfIntegers, Consumer<Integer> consumer) {
		listOfIntegers.forEach(consumer);
		// Lo mismo anterior pero con lambda expresions
		// listOfIntegers.forEach(i-> System.out.print(" "+i));
		/*
		 * for (Integer integer : listOfIntegers) { consumer.accept(integer); }
		 */
	}

	public static Date getSystemDate() {
		return new Date();
	}

	public static List<String> convertEmpListToNamesList(List<Employee> employeeList,
			Function<Employee, String> funcEmpToString) {
		List<String> empNameList = new ArrayList<String>();
		for (Employee emp : employeeList) {
			empNameList.add(funcEmpToString.apply(emp));
		}
		return empNameList;
	}

	public static List<Employee> applyIdentityToEmpList(List<Employee> employeeList,
			Function<Employee, Employee> funcEmpToEmp) {
		List<Employee> empNameList = new ArrayList<Employee>();
		for (Employee emp : employeeList) {
			empNameList.add(funcEmpToEmp.apply(emp));
		}
		return empNameList;
	}
}
