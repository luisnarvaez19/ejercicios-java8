package com.sci.varios;

public class Escribir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i < 31; i++) {
			if ((i % 3 == 0) && (i % 5 == 0))
				System.out.println("FOOFAA");
			else if (i % 3 == 0)
				System.out.println("FOO");
			else if (i % 5 == 0)
				System.out.println("FAA");
			else
				System.out.println(i);
		}

	}

}
