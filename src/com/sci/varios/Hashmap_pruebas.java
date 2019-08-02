package com.sci.varios;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class Hashmap_pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,String> map = new HashMap<>();
		map.put(21, "Twenty One");
		Integer key = 21;
		String value = map.get(key);
		System.out.println("Key: " + key +" value: "+ value); 
		map.put(31, "Thirty One");       
		for (Iterator<Integer> iterator = map.keySet().iterator(); iterator.hasNext();) {
			key = (Integer) iterator.next();
			System.out.println("key: " + key + " value: " + map.get(key));
		}
		Iterator<Integer> keySetIterator = map.keySet().iterator();

		while(keySetIterator.hasNext()){
		  key = keySetIterator.next();
		  System.out.println("key: " + key + " value: " + map.get(key));
		}
		map.put(41, "Thirty One");

		System.out.println("Unsorted HashMap: " + map);
		TreeMap<Integer, String> sortedHashMap = new TreeMap<>(map);     
		System.out.println("Sorted HashMap: " + sortedHashMap); 
		
	}

}
