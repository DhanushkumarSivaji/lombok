package com.dhanush.lombok.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhanush.lombok.entity.Students;
import com.dhanush.lombok.repository.StudentRepository;
import com.dhanush.lombok.request.CreateStudentRequest;
import com.dhanush.lombok.request.UpdateStudentRequest;

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
	
	public Students updateStudent (UpdateStudentRequest updateStudentRequest) {
		Students student = studentRepository.findById(updateStudentRequest.getId()).get();
		
		if(updateStudentRequest.getFirstName() != null && !updateStudentRequest.getFirstName().isEmpty()) {
			student.setFirstName(updateStudentRequest.getFirstName());
		}
		
		student = studentRepository.save(student);
		
		return student;

	}
	
	public String deleteStudent (long id) {
		studentRepository.deleteById(id);
		return "Student has been deleted successfully";
	}
}
