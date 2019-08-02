package com.sci.varios;

public class Priorities {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int i;
//		do {
//			//i++;
//		}
//		while (i>0);
//		System.out.println(i);
		int[] arr= {1,2,3,4};
		call_array(arr[0], arr);
		System.out.println(arr[0]+","+arr[1]);
	}
	static void call_array(int i, int arr[]) {
		arr[i]=6;
		i=5;
	}

}
