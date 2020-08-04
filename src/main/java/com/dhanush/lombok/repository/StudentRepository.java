package com.dhanush.lombok.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhanush.lombok.entity.Students;

@Repository
public interface StudentRepository extends JpaRepository<Students, Long> {
	
}
