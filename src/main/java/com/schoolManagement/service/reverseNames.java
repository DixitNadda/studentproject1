package com.schoolManagement.service;

import java.util.Comparator;

import com.schoolManagement.entity.Student;

public class reverseNames implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
	
		return  s2.getFirstName().compareTo(s1.getFirstName());
	}

}
