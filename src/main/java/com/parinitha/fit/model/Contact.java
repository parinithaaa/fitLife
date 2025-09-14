package com.parinitha.fit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Contact {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
	
	@NotBlank(message = "Name must not be blank")
	@Size(min = 3, message = "Name must be at least 3 characters long")
	String name;


	@NotBlank(message = "Email must not be blank")
	@Email(message = "Please provide a valid email address")
	String email;

	@NotBlank(message = "Message must not be blank")
	@Size(min = 10, message = "Message must be at least 10 characters long")
	String message;

}