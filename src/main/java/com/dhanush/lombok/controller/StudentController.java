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
import com.dhanush.lombok.request.InQueryRequest;
import com.dhanush.lombok.request.UpdateStudentRequest;
import com.dhanush.lombok.response.StudentResponse;
import com.dhanush.lombok.service.StudentService;

@RestController
@RequestMapping("/api/student/")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("getAll")
	public List<StudentResponse> getAllStudents() {
		List<Students> studentList = studentService.getAllStudents();
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();

		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});

		return studentResponseList;
	}

	@PostMapping("create")
	public StudentResponse createStudent(@Validated @RequestBody CreateStudentRequest createStudentRequest) {
		Students student = studentService.createStudent(createStudentRequest);
		return new StudentResponse(student);
	}

	@PutMapping("update")
	public StudentResponse updateStudent(@Validated @RequestBody UpdateStudentRequest updateStudentRequest) {
		Students student = studentService.updateStudent(updateStudentRequest);

		return new StudentResponse(student);
	}

//	@DeleteMapping("delete")
//	public String deleteStudent (@RequestParam("id") long id) {
//		return studentService.deleteStudent(id);
//	}

	@DeleteMapping("delete/{id}")
	public String deleteStudent(@PathVariable long id) {
		return studentService.deleteStudent(id);
	}

	@GetMapping("getByFirstName/{firstName}")
	public List<StudentResponse> getByFirstName(@PathVariable String firstName) {
		List<Students> studentList = studentService.getByFirstName(firstName);

		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();

		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});

		return studentResponseList;

	}

	@GetMapping("getByFirstNameAndLastName/{firstName}/{lastName}")
	public StudentResponse getByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName) {
		return new StudentResponse(studentService.getByFirstNameAndLastName(firstName, lastName));
	}

	@GetMapping("getByFirstNameOrLastName/{firstName}/{lastName}")
	public List<StudentResponse> getByFirstNameOrLastName(@PathVariable String firstName,
			@PathVariable String lastName) {
		List<Students> studentList = studentService.getByFirstNameOrLastName(firstName, lastName);

		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();

		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});

		return studentResponseList;
	}

	@GetMapping("getByFirstNameIn")
	public List<StudentResponse> getByFirstNameIn(@RequestBody InQueryRequest inQueryRequest) {
		List<Students> studentList = studentService.getByFirstNameIn(inQueryRequest);

		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();

		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});

		return studentResponseList;
	}

	@GetMapping("getAllWithPagination")
	public List<StudentResponse> getAllStudentsWithPagination(@RequestParam int pageNo, @RequestParam int pageSize) {
		List<Students> studentList = studentService.getAllStudentsWithPagination(pageNo, pageSize);

		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();

		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});

		return studentResponseList;
	}

	@GetMapping("getAllWithSorting")
	public List<StudentResponse> getAllStudentsWithSorting() {

		List<Students> studentList = studentService.getAllStudentsWithSorting();

		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();

		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});

		return studentResponseList;
	}

	@PutMapping("updateFirstName/{id}/{firstName}")
	public String updateStudentWithJpql(@PathVariable Long id, @PathVariable String firstName) {
		return studentService.updateStudentWithJpql(id, firstName) + " Student(s) updated";
	}

	@DeleteMapping("deleteByFirstName/{firstName}")
	public String deleteStudent(@PathVariable String firstName) {
		return studentService.deleteStudent(firstName) + " Student(s) deleted";
	}
	
	@GetMapping("/getByCity/{city}")
	public List<StudentResponse> getByCity(@PathVariable String city) {
		List<Students> studentList = studentService.getByCity(city);

		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();

		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});

		return studentResponseList;

	}
	
}
