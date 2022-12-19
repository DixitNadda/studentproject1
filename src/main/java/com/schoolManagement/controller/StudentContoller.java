package com.schoolManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.schoolManagement.entity.Student;
import com.schoolManagement.service.StudentService;

@RestController
public class StudentContoller {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	@GetMapping("/studentAtRollNo/{rollNo}")
	public Student getStudentAtRollNo(@PathVariable("rollNo") int rollNo) {
		 return studentService.getStudentAtRollNo(rollNo);
	}	
	@GetMapping("/rollNoViz")
	public List<Student> rollNoViz() {
		return studentService.studentsRollNoViz();
	}
	@GetMapping("/reverseRollNums")
	public List<Student> revrseRollno() {
		return studentService.reverseRollno();
    }
	@GetMapping("/sortNames")
	public List<Student> sortNames(){
		return studentService.sortByName();
	}
	@GetMapping("/reverseNames")
	public List<Student> revrseOfNames(){
		return studentService.reversedNames();
	}
	
	 @PostMapping("/students")
	public List<Student> addStudents(@RequestBody  List<Student> student){
		return studentService.addStudents(student);
	}		
	@PostMapping("/oneStudent")
	public Student addStudent(@RequestBody Student student){
		return studentService.addStudent(student);
	}
		
	@PutMapping("/update/{rollno}")
	public String updateStudent(@RequestBody Student student,@PathVariable("rollno") int rollno) {
		boolean  b =	this.studentService.updateStudent(student, rollno);
		String s;
		return s = b ? "Yes, data has updted." : "No student found at rollno "+rollno;  // conditional operator(?:)
	}
	
	// DELETE DATA
	@DeleteMapping("/delete/{rollNo}")
	public String removeStudent(@PathVariable int rollNo) {
		 return studentService.deleteStudent(rollNo); 
	}
}

