package com.sci.mkyong;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestSorting {

	public static void main(String[] args) {

		List<Developer> listDevs = getDevelopers();

		System.out.println("Before Sort");
		for (Developer developer : listDevs) {
			System.out.println(developer);
		}
		
		//sort by age
		Collections.sort(listDevs, new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getEdad() - o2.getEdad();
			}
		});
	
		
		/*
		 * When the sorting requirement is changed, you just pass in another new anonymous Comparator class :
		 * //sort by name	
		Collections.sort(listDevs, new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getNombre().compareTo(o2.getNombre());
			}
		});
					
		//sort by salary
		Collections.sort(listDevs, new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getSueldo().compareTo(o2.getSueldo());
			}
		});		
		
		*
		*    It works, but, do you think it is a bit weird to create a class just because you want to change
		*     a single line of code?
		*/
	
		System.out.println("After Sort");
		for (Developer developer : listDevs) {
			System.out.println(developer);
		}
		
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
