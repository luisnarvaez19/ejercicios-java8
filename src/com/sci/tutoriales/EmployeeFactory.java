package com.sci.tutoriales;

// Note – Since EmployeeFactory interface has a single abstract method hence it is a Functional Interface.

@FunctionalInterface
public interface EmployeeFactory {
	public abstract Employee getEmployee(String name, Integer age);
}