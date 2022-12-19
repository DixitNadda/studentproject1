package com.schoolManagement.service;

import java.util.Comparator;

import com.schoolManagement.entity.Student;

public class SortByNames implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {

		return  s1.getFirstName().compareTo(s2.getFirstName());
	}	

}

