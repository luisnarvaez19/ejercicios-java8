package com.sci.tutoriales;

@FunctionalInterface
public interface CustomFunctionalInterface {
	// This is the only abstract method.Hence, this
	// interface qualifies as a Functional Interface
	// Single abstract method
	public void firstMethod();
	public static void firstMethod2() {
		
	}
	public static void firstMethod1() {
		
	}
	public default void firstMethod3() {
		
	}
	public default void firstMethod4() {
		
	}
}
