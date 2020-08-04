package com.dhanush.lombok.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhanush.lombok.entity.Students;
import com.dhanush.lombok.repository.StudentRepository;
import com.dhanush.lombok.request.CreateStudentRequest;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public List<Students> getAllStudents () {
		return studentRepository.findAll();
	}
	
	public Students createStudent (CreateStudentRequest createStudentRequest) {
		Students student = new Students(createStudentRequest);
		student = studentRepository.save(student);
		return student;
	}
	
}
