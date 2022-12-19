package com.schoolManagement.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.schoolManagement.entity.Student;
import com.schoolManagement.entity.ReverseRollNo;
import com.schoolManagement.repository.StudentRepository;

@Controller
public class StudentService {
	
	
	@Autowired
	private StudentRepository studentRepository;
	
	// add one student
	public Student addStudent(Student student) { 	
		return studentRepository.save(student);
	}
	// add multiple students
	public List<Student> addStudents(List<Student> students) {
		System.out.println("\n"+students+"\n"); 
		return studentRepository.saveAll(students);
	}
	
	// GET single STUDENT
	public Student getStudentAtRollNo(int rollNo){
		 return studentRepository.findById(rollNo).orElse(null);
	}
	// get All students
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	// get students rollNumber viz
	public List<Student> studentsRollNoViz() {
		 List<Student> rollNoViz =   studentRepository.findAll();
		 Collections.sort(studentRepository.findAll(), new RollNoViz());
		 return rollNoViz;
	}
	
	// get Students by Reversed Roll Numbers
	public List<Student> reverseRollno(){
		List<Student> listRevrseRollNo = studentRepository.findAll();
		Collections.sort(listRevrseRollNo, new ReverseRollNo());	
		return listRevrseRollNo;
	}
	// get students in reverse alphabetical order
	public  List<Student> reversedNames(){
		List<Student> listNames = studentRepository.findAll();
		Collections.sort(listNames, new reverseNames());
		return listNames;
	}	
	// get students in Reverse order of Names
	public List<Student> sortByName(){
		List<Student> listNames = studentRepository.findAll();
		Collections.sort(listNames, new SortByNames());
		return listNames;
	}
	// update student
	public boolean updateStudent(Student student, int rollno) {
		Optional<Student> stu =  studentRepository.findById(rollno);
		
		if(stu.isPresent()) {
			Student stud	= stu.get();
			stud.setFirstName(student.getFirstName());
			stud.setLastName(student.getLastName());
			stud.setStandard(student.getStandard());
			stud.setDob(student.getDob());
			stud.setFathersName(student.getFathersName());
			stud.setAddress(student.getAddress());
			studentRepository.save(stud);
			return true;
		}else {
			try {
				throw new Exception("No student found at rollno:"+rollno);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false;			
	}
	
	//	DELETE STUDENT
	public String deleteStudent(int rollno){
		 studentRepository.deleteById(rollno);
		 return "Record of student with rollno "+rollno+" has removed.";
	}
}


