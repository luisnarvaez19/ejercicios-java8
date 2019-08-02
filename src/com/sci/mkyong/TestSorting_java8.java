package com.sci.mkyong;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestSorting_java8 {

	public static void main(String[] args) {

		List<Developer> listDevs = getDevelopers();

		System.out.println("Before Sort");
		for (Developer developer : listDevs) {
			System.out.println(developer);
		}
		
		
		System.out.println("After Sort con lambdas");
		
		//lambda here!
		listDevs.sort((Developer o1, Developer o2)->o1.getEdad()-o2.getEdad());
			
		//lambda
		listDevs.sort((o1, o2)->o1.getNombre().compareTo(o2.getNombre()));
		
		listDevs.sort((o1, o2)->o1.getSueldo().compareTo(o2.getSueldo()));
		
		Comparator<Developer> salaryComparator = (o1, o2)->o1.getSueldo().compareTo(o2.getSueldo());
		listDevs.sort(salaryComparator);
		
		//  Lambda expression to sort a List using their salary, reversed order.
		
		salaryComparator = (o1, o2)->o1.getSueldo().compareTo(o2.getSueldo());
		listDevs.sort(salaryComparator.reversed());
		
		//java 8 only, lambda also, to print the List
		listDevs.forEach((developer)->System.out.println(developer));
		
		
	}

	private static List<Developer> getDevelopers() {

		List<Developer> result = new ArrayList<Developer>();

		result.add(new Developer("com/sci/mkyong", new BigDecimal("70000"), 33));
		result.add(new Developer("alvin", new BigDecimal("80000"), 20));
		result.add(new Developer("jason", new BigDecimal("100000"), 10));
		result.add(new Developer("iris", new BigDecimal("170000"), 55));
		result.add(new Developer("luis", new BigDecimal("170000"), 54));
		
		return result;

	}
	
}
