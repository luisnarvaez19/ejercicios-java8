package com.sci.tutoriales;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class User {
	 String name, role;
	    User(String a, String b) {
	        name = a;
	        role = b;
	    }
	    String getRole() { return role; }
	    String getName() { return name; }    
	    public String toString() {
	       return "User Name : " + name + ", Role :" + role;
	    }
	 
	   
	 
	    public static List<User> process(List<User> users, 
	                            Predicate<User> predicat)
	    {
	        List<User> result = new ArrayList<User>();
	        for (User user: users)        
	            if (predicat.test(user))            
	                result.add(user);
	        return result;
	    }
}
