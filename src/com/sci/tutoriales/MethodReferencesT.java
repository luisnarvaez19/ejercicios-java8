package com.sci.tutoriales;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReferencesT {

	public static void main(String[] args) {
		
		// Type 1: Reference to a static method –
		Function<String, Double> doubleConvertor = Double::parseDouble;
		Function<String, Double> doubleConvertorLambda = (String s) -> Double.parseDouble(s);
		System.out.println("double value using method reference - " + doubleConvertor.apply("0.254"));
		System.out.println("double value using Lambda - " + doubleConvertorLambda.apply("0.254"));
		
		
		// Type 2: Reference to an instance method of a particular object –
		Consumer<String> stringPrinter=System.out::println;
		Consumer<String> stringPrinterLambda=(String s) -> System.out.println(s);
		stringPrinter.accept("Print from method reference based instance");
		stringPrinterLambda.accept("Print from instance created from Lambda");
		
		// Type 3: Reference to an instance method of an arbitrary object of a particular type– 
		List<Integer> intList=Arrays.asList(1,2,3,4);
		BiPredicate<List<Integer>,Integer> isPartOf=List::contains;
		BiPredicate<List<Integer>,Integer> isPartOfLambda=(List<Integer> listInt, Integer value) -> listInt.contains(value);
		System.out.println("Is 3 a part of the intList - "+ isPartOf.test(intList, 3));
		System.out.println("Is 2 a part of the intList - "+ isPartOfLambda.test(intList, 2));

		// TYpe 4: Constructor Reference	
		// There is a 4th type of specialized method reference called Constructor Reference.
		
		EmployeeFactory empFactory=Employee::new;
		Employee emp= empFactory.getEmployee("John Hammond", 25);
		
		stringPrinter.accept("El empleado: "+emp.getName()+" de edad: "+ emp.getAge());
		
	}

}
