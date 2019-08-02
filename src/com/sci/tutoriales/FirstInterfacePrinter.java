package com.sci.tutoriales;


public class FirstInterfacePrinter {

	public void print(FirstInterface firstInterface) {
		firstInterface.singleMethod("apple");
	}

	public static void main(String args[]) {
		FirstInterfacePrinter printer = new FirstInterfacePrinter();
		printer.print((String param) -> {
			System.out.println("My lambda says " + param);
		});

	}

}
