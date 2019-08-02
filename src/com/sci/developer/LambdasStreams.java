package com.sci.developer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class LambdasStreams {
/**
 *      Streams are wrappers around collections that use lambdas pervasively. They support many operations that use 
 *      lambdas, like map, filter, limit, sorted, count, min, max, sum, collect and others. Also, streams use lazy 
 *      evaluation and they are not actually reading all the data and methods like getFirst() can end the stream.
 *       In the next examples, we will explore what lambdas and streams can do. We created a Person class and use 
 *       this class to add some data to a list that will be used in further streams operations.
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Going further, we will create two lists, both containing Person objects:
		
		 List<Person> javaProgrammers = new ArrayList<Person>() {
	            /**
			 * 
			 */
			private static final long serialVersionUID = -7686082579161224657L;

				{
	                add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
	                add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
	                add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
	                add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
	                add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
	                add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
	                add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
	                add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
	                add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
	                add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
	            }
	        };
	 
	        List<Person> phpProgrammers = new ArrayList<Person>() {
	         

				{
	                add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
	                add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
	                add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
	                add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
	                add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));
	                add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
	                add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));
	                add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
	                add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
	                add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
	            }
	        };
	        // Let’s now use the forEach method to iterate the above lists:
	        
	        System.out.println("Show java programmers names:");
	        javaProgrammers.forEach((p) -> System.out.printf("%s %s: %d;  ", p.getFirstName(), p.getLastName(), p.getSalary()));
	        System.out.println("\nShow php programmers names:");
	        phpProgrammers.forEach((p) -> System.out.printf("%s %s: %d;  ", p.getFirstName(), p.getLastName(), p.getSalary()));
	        
	        // We will now use the same forEach method and try to increase programmer’s salary by 5%:

	        System.out.println("Increase salary by 5% to programmers:");
	        Consumer<Person> giveRaise = e -> e.setSalary(e.getSalary() / 100 * 5 + e.getSalary());
	         
	        javaProgrammers.forEach(giveRaise);
	        phpProgrammers.forEach(giveRaise);
	        System.out.println("Show java programmers names:");
	        javaProgrammers.forEach((p) -> System.out.printf("%s %s: %d;  ", p.getFirstName(), p.getLastName(), p.getSalary()));
	       
	        // Another useful method is the filter method. To make use of that, let’s show PHP programmers that earn 
	        // more than $1,400:
	        System.out.println("Show PHP programmers that earn more than $1,400:");
	        phpProgrammers.stream()
	                  .filter((p) -> (p.getSalary() > 1400))
	                  .forEach((p) -> System.out.printf("%s %s: %d; ", p.getFirstName(), p.getLastName(), p.getSalary()));
	        
	        // We can also define filters and then reuse them in further operations:
	        // Define some filters
	        
	        Predicate<Person> ageFilter = (p) -> (p.getAge() > 25);
	        Predicate<Person> salaryFilter = (p) -> (p.getSalary() > 1400);
	        Predicate<Person> genderFilter = (p) -> ("female".equals(p.getGender()));
	         
	        System.out.println("\nShow female PHP programmers that earn more than $1,400 and are older than 24 years:");
	        phpProgrammers.stream()
	                  .filter(ageFilter)
	                  .filter(salaryFilter)
	                  .filter(genderFilter)
	                  .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
	         
	        // Reuse filters
	        System.out.println("\nShow female Java programmers older than 24 years:");
	        javaProgrammers.stream()
	                  .filter(ageFilter)
	                  .filter(genderFilter)
	                  .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
	        System.out.println("\nShow first 3 Java programmers:");
	        javaProgrammers.stream()
	                  .limit(3)
	                  .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
	         
	        // Results can also be limited, if we use the limit method:
	        
	        System.out.println("\nShow first 3 female Java programmers:");
	        javaProgrammers.stream()
	                  .filter(genderFilter)
	                  .limit(3)
	                  .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
	        
	        // What about sorting? Can we do that with streams? The answer is yes, we can. In the examples below, 
	        // we will sort Java programmers by name and salary, collect them into a list and then show the list:
	        
	        System.out.println("\nSort and show the first 5 Java programmers by name:");
	        List<Person> sortedJavaProgrammers = javaProgrammers
	                  .stream()
	                  .sorted((p, p2) -> (p.getFirstName().compareTo(p2.getFirstName())))
	                  .limit(5)
	                  .collect(toList());

	         
	        sortedJavaProgrammers.forEach((p) -> System.out.printf("%s %s; %n", p.getFirstName(), p.getLastName()));
	         
	        System.out.println("Sort and show Java programmers by salary:");
	        sortedJavaProgrammers = javaProgrammers
	                  .stream()
	                  .sorted((p, p2) -> (p.getSalary() - p2.getSalary()))
	                  .collect(Collectors.toCollection(ArrayList::new));
	         
	        sortedJavaProgrammers.forEach((p) -> System.out.printf("%s %s: %d; %n", p.getFirstName(), p.getLastName(),p.getSalary()));
	 
	        // If we are interested only in the lowest and the highest salary, faster than sorting and choosing the first
	        // (or the last) are the min and max methods:
	        
	        System.out.println("Get the lowest Java programmer salary:");
	        Person pers = javaProgrammers
	                  .stream()
	                  .min((p1, p2) -> (p1.getSalary() - p2.getSalary()))
	                  .get();
	         
	        System.out.printf("Name: %s %s; Salary: $%,d.", pers.getFirstName(), pers.getLastName(), pers.getSalary());
	         
	        System.out.println("\nGet the highest Java programmer salary:");
	        Person person = javaProgrammers
	                  .stream()
	                  .max((p, p2) -> (p.getSalary() - p2.getSalary()))
	                  .get();
	         
	        System.out.printf("Name: %s %s; Salary: $%,d.", person.getFirstName(), person.getLastName(), person.getSalary());
	        
	        // We have already seen above an example on how the collect method works. Combined with the map method,
	        // we can use collect method to gather our results in a String, in a Set or in a TreeSet:
	        
	        System.out.println("Get PHP programmers first name to String:");
	        String phpDevelopers = phpProgrammers
	                  .stream()
	                  .map(Person::getFirstName)
	                  .collect(joining(" ; "));    // this can be used as a token in further operations
	        System.out.println("phpDevelopers: "+phpDevelopers); 
	        
	        System.out.println("Get Java programmers first name to Set:");
	        Set<String> javaDevFirstName = javaProgrammers
	                  .stream()
	                  .map(Person::getFirstName)
	                  .collect(toSet());
	         
	        System.out.println("Get Java programmers last name to TreeSet:");
	        TreeSet<String> javaDevLastName = javaProgrammers
	                  .stream()
	                  .map(Person::getLastName)
	                  .collect(toCollection(TreeSet::new));
	        
	        // Streams can also be parallel. An example is below:
	        
	        System.out.println("Calculate total money spent for paying Java programmers:");
	        int totalSalary = javaProgrammers
	                  .parallelStream()
	                  .mapToInt(p -> p.getSalary())
	                  .sum();
	        
	        // To obtain various summary data about the elements of a stream we can use
	        // the summaryStatistics method. Going further, we then have access to methods like getMax, getMin, getSum or getAverage:
	        
	      //Get count, min, max, sum, and average for numbers
	        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	        IntSummaryStatistics stats = numbers
	                  .stream()
	                  .mapToInt((x) -> x)
	                  .summaryStatistics();
	         
	        System.out.println("Highest number in List : " + stats.getMax());
	        System.out.println("Lowest number in List : " + stats.getMin());
	        System.out.println("Sum of all numbers : " + stats.getSum());
	        System.out.println("Average of all numbers : " + stats.getAverage()); 
	         
	        	               
	}

}
