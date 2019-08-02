package com.sci.tutoriales;

import java.util.Arrays;
import java.util.List;

public class OtrosT {

	/**
	 * External Iterators Definition(or Active Iterators) – With external iterators
	 * responsibility of iterating over the elements, and making sure that this
	 * iteration takes into account the total number of records, whether more
	 * records exist to be iterated and so on lies with the programmer.
	 * 
	 * Internal Iterators(or Passive Iterators) – Internal Iterators manage the
	 * iterations in the background. This leaves the programmer to just
	 * declaratively code what is meant to be done with the elements of the
	 * Collection, rather than managing the iteration and making sure that all the
	 * elements are processed one-by-one.
	 * 
	 * Advantage of internal iterators over external iterators
	 * 
	 * Improved code readability as its declarative in nature Concise code as
	 * multiple lines of code for external iterators is reduced to just one or two
	 * lines of code in case of internal iterators Simplified implementation/less
	 * defects as code written by programmer is very less, chances of bugs creeping
	 * into the iteration logic are not there. Point in favor of external iterators
	 * If you want more control over the iteration, and want to perform some check
	 * or operation for a particular index then external iterators are preferred
	 * over internal ones.
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// External Iterator
		List<String> namesList = Arrays.asList("Tom", "Dick", "Harry");
		for (String name : namesList) {
			System.out.println(name);
		}

		// Internal Iterator
		namesList = Arrays.asList("Tom", "Dick", "Harry");
		namesList.forEach(name -> System.out.println(name));// Internal Iteration

	}
}
