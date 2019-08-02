package com.sci.developer;

import java.util.Arrays;
import java.util.List;

public class Lambdas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Resultado:"+valor(7));
		
		String[] atp = {"Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka", "David Ferrer", "Roger Federer", "Andy Murray", "Tomas Berdych", "Juan Martin Del Potro"};
		List<String> players =  Arrays.asList(atp);
		       
		// Old looping
		System.out.println("Old looping");
		for (String player : players) {
		     System.out.print(player + "; ");
		}
		       
		System.out.println("\nLambda looping");
		// Using lambda expression and functional operations
		players.forEach((player) -> System.out.print(player + "; "));
		
		System.out.println("\nDoble colon operator");
		// Using double colon operator in Java 8
		players.forEach(System.out::println);
		
		// Using anonymous innerclass 
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello world !");
			}
		}).start();
		 
		// Using lambda expression
		new Thread(() -> System.out.println("Hello world lambda !")).start();
		
		// Using anonymous innerclass
		Runnable race1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello world race1!");
			}
		};
		 
		// Using lambda expression
		Runnable race2 = () -> System.out.println("Hello world race2!");
		 
		// Run em!
		race1.run();
		race2.run();
		
	}

	public static Integer valor(Integer par) {
		IMyFunc valor=(x)-> 2*x;
		return valor.getValue(par);
	}
}
