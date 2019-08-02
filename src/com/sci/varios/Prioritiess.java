package com.sci.varios;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Prioritiess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<String> toDo = new PriorityQueue<>(5, Comparator.comparing(String::length));
		toDo.add("dishes");
		toDo.add("laun");
		toDo.add("bills");
		toDo.add("bills");
		System.out.print(toDo.size()+" "+toDo.poll());
		System.out.print(" "+toDo.peek()+" "+toDo.poll());
		System.out.println(" "+toDo.poll()+" "+toDo.poll());
		
		
		// Usando java8
		PriorityQueue<String> pq=
                new PriorityQueue<String>(5, (a,b) -> a.length() - b.length());
        pq = new PriorityQueue<String>(5, Comparator.comparing(String::length));
        pq.add("Apple");
        pq.add("PineApple");
        pq.add("Custard Apple");
        while (pq.size() != 0)
        {
            System.out.println(pq.remove());
        }
	}

}
