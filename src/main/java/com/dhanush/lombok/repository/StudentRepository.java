package com.dhanush.lombok.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dhanush.lombok.entity.Students;

@Repository
public interface StudentRepository extends JpaRepository<Students, Long> {
	List<Students> findByFirstName(String firstName); 
	Students findByFirstNameAndLastName(String firstName ,String lastName);
	List<Students> findByFirstNameOrLastName(String firstName ,String lastName);
	List<Students> findByFirstNameIn(List<String> firstNames);
	@Query("From Students where firstName = :firstname and lastName = :lastName")
	Students getByFirstNameAndLastName(@Param("firstname") String firstName ,String lastName);
	
	@Modifying
	@Transactional
	@Query("Update Students set firstName = :firstName where id = :id")
	Integer updateFirstName (Long id, String firstName);
	
	@Modifying
	@Transactional
	@Query("Delete From Students where firstName = :firstName")
	Integer deleteByFirstName (String firstName);
	
	List<Students> findByAddressCity(String city);
	
	@Query("From Students where address.city = :city")
	List<Students> getByAddressCity(String city);
	
	
}
