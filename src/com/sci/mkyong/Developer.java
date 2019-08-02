package com.sci.mkyong;

import java.math.BigDecimal;

public class Developer {
	private String nombre;
	private BigDecimal sueldo;
	private Integer edad;
	
	
	public Developer(String nombre, BigDecimal sueldo, Integer edad) {
		super();
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.edad = edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getSueldo() {
		return sueldo;
	}
	public void setSueldo(BigDecimal sueldo) {
		this.sueldo = sueldo;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Developer [nombre=" + nombre + ", sueldo=" + sueldo + ", edad=" + edad + "]";
	}
	
	
}
