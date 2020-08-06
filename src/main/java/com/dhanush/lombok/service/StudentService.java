package com.dhanush.lombok.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dhanush.lombok.entity.Students;
import com.dhanush.lombok.repository.StudentRepository;
import com.dhanush.lombok.request.CreateStudentRequest;
import com.dhanush.lombok.request.InQueryRequest;
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
		
		if(updateStudentRequest.getLastName() != null && !updateStudentRequest.getLastName().isEmpty()) {
			student.setLastName(updateStudentRequest.getLastName());
		}
		
		student = studentRepository.save(student);
		
		return student;

	}
	
	public String deleteStudent (long id) {
		studentRepository.deleteById(id);
		return "Student has been deleted successfully";
	}
	
	public List<Students> getByFirstName(String firstName){
		return studentRepository.findByFirstName(firstName);
	}
	
	public Students getByFirstNameAndLastName(String firstName,String lastName){
//		return studentRepository.findByFirstNameAndLastName(firstName, lastName);
		return studentRepository.getByFirstNameAndLastName(firstName, lastName);
	};
	
	public List<Students> getByFirstNameOrLastName(String firstName,String lastName){
		return studentRepository.findByFirstNameOrLastName(firstName, lastName);
	}
	public List<Students> getByFirstNameIn(InQueryRequest inQueryRequest){
		return studentRepository.findByFirstNameIn(inQueryRequest.getFirstNames());
	}
	public List<Students> getAllStudentsWithPagination(int pageNo , int pageSize){
		PageRequest pageable = PageRequest.of(pageNo - 1, pageSize);
		
			return studentRepository.findAll(pageable).getContent();
	}
	public List<Students> getAllStudentsWithSorting () {
		Sort sort = Sort.by(Sort.Direction.ASC, "firstName", "lastName", "email");
		
		return studentRepository.findAll(sort);
	}
	
	public Integer updateStudentWithJpql (Long id, String firstName) {
		return studentRepository.updateFirstName(id, firstName);
	}
	
	public Integer deleteStudent (String firstName) {
		return studentRepository.deleteByFirstName(firstName);
	}
}
