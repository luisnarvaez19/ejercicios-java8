package com.sci.tutoriales;

public class Employee {
	private String name;
	private Integer age;
	private Double salary;

	public Employee(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public Employee(String name, Integer age, Double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String toString() {
		return "Employee Name:" + this.name + "  Age:" + this.age +"  Salary: "+this.salary;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee empObj = (Employee) obj;
		return this.age == empObj.age && this.name.equalsIgnoreCase(empObj.name);
	}

	@Override
	public int hashCode() {
		int hash = 1;
		hash = hash * 17 + this.name.hashCode();
		hash = hash * 31 + this.age;
		return hash;
	}
}
