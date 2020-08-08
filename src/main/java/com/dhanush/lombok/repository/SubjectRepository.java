package com.dhanush.lombok.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhanush.lombok.entity.Subject;



@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
