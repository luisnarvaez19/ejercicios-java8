package com.sci.developer;

import java.util.Arrays;
import java.util.List;

public class Lambdas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Resultado ----------------------------------------->:   "+valor(5));
		System.out.println("Words in the string " + valor2("Functional interface in Java"));
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

	/**
	 * IMyFunc:  Es una interfase funcional
	 * @param par
	 * @return
	 */
	public static int valor(Integer par) {

		IMyFunc valor = (num) -> {
			int fact = 1;
			for (int i = 1; i <= num; i++) {
				fact = i * fact;
			}
			return fact;
		};
		return valor.getValue(par);
	}

	public static int valor2(String par) {

		IMyFunc2<String, Integer> countWords = (str) -> {
			int c = 0;
			char ch[]= new char[str.length()];
			for(int i = 0; i < str.length(); i++){
				ch[i] = str.charAt(i);
				if(((i > 0) && (ch[i] != ' ') && (ch[i-1] == ' ')) ||
						((ch[0] != ' ') && (i == 0)))
					c++;
			}
			return c;
		};
		return countWords.func(par);
	}

}
