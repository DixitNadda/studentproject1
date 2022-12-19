package com.schoolManagement.service;

import java.util.Comparator;

import com.schoolManagement.entity.Student;

public class RollNoViz implements Comparator<Student> {
	
	public int compare(Student s1, Student s2) {
		
		if(s1.getRollno() > s2.getRollno()) {
			return -1;
		}
		else if(s1.getRollno() < s2.getRollno()) {
			return 1;
		}
		else 
			return 0;	
	}
}
