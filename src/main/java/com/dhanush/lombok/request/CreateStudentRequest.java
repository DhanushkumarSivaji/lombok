package com.dhanush.lombok.request;

import java.util.List;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStudentRequest {
	
	@NotBlank(message="First Name is required")
	private String firstName;
	private String lastName;
	private String email;
	
	private String street;
	private String city;
	
	
	private List<CreateSubjectRequest> subjectsLearning;
	

}
