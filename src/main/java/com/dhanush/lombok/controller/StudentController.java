package com.dhanush.lombok.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dhanush.lombok.entity.Students;
import com.dhanush.lombok.request.CreateStudentRequest;
import com.dhanush.lombok.request.UpdateStudentRequest;
import com.dhanush.lombok.response.StudentResponse;
import com.dhanush.lombok.service.StudentService;

@RestController
@RequestMapping("/api/student/")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@GetMapping("getAll")
	public List<StudentResponse> getAllStudents () {
		List<Students> studentList = studentService.getAllStudents();
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
		
		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		
		return studentResponseList;
	}
	
	@PostMapping("create")
	public StudentResponse createStudent (@Validated @RequestBody CreateStudentRequest createStudentRequest) {
		Students student = studentService.createStudent(createStudentRequest);
		return new StudentResponse(student);
	}
	
	@PutMapping("update")
	public StudentResponse updateStudent (@Validated @RequestBody UpdateStudentRequest updateStudentRequest) {
		Students student = studentService.updateStudent(updateStudentRequest);
		
		return new StudentResponse(student);
	}
	
//	@DeleteMapping("delete")
//	public String deleteStudent (@RequestParam("id") long id) {
//		return studentService.deleteStudent(id);
//	}
	
	@DeleteMapping("delete/{id}")
	public String deleteStudent (@PathVariable long id) {
		return studentService.deleteStudent(id);
	}
}
