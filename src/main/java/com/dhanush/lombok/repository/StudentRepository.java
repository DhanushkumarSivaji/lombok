package com.dhanush.lombok.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhanush.lombok.entity.Students;

@Repository
public interface StudentRepository extends JpaRepository<Students, Long> {
	List<Students> findByFirstName(String firstName); 
	Students findByFirstNameAndLastName(String firstName ,String lastName);
	List<Students> findByFirstNameOrLastName(String firstName ,String lastName);
	List<Students> findByFirstNameIn(List<String> firstNames);
}
