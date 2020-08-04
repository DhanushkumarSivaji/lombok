package com.dhanush.lombok.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhanush.lombok.entity.Students;
import com.dhanush.lombok.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public List<Students> getAllStudents () {
		return studentRepository.findAll();
	}
}
