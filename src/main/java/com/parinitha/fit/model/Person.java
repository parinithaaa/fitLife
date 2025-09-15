package com.parinitha.fit.model;

import com.springboot.springBootDemo.annotations.PasswordValidator;

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
public class Person {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long personId;

	    @NotBlank(message="Name must not be blank")
	    @Size(min=3, message="Name must be at least 3 characters long")
	    private String name;

	    @NotBlank(message="Email must not be blank")
	    @Email(message = "Please provide a valid email address" )
	    private String email;

	    @NotBlank(message="Password must not be blank")
	    @Size(min=5, message="Password must be at least 5 characters long")
	    private String pwd;   

	    private String roles; 

}
