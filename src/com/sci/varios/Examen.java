package com.sci.varios;

public class Examen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1};
		Examen t= new Examen();
		t.increment(a);
		System.out.println(a[a.length - 1]);
	}
	void increment(int[] i) {
		i[i.length -1 ]++;
	}
}
