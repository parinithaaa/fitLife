package com.parinitha.fit.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.*;

import annotations.PasswordValidator;
import jakarta.persistence.*;
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

	
	    private String name;

	    @NotBlank(message="Email must not be blank")
	    @Email(message = "Please provide a valid email address" )
	    private String email;

	    @NotBlank(message="Password must not be blank")
	    @Size(min=5, message="Password must be at least 5 characters long")
	    @PasswordValidator
	    private String pwd;   

	    private String roles; 

	    private int age;
	    private double height; // in cm
	    private double weight; // in kg
	    private String gender;

	    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	    private List<Goal> goals = new ArrayList<>();

	    @ManyToMany
	    @JoinTable(
	        name = "person_exercise",
	        joinColumns = @JoinColumn(name = "personId"),
	        inverseJoinColumns = @JoinColumn(name = "exerciseId")
	    )
	    private List<Exercise> exercises = new ArrayList<>();

	    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
	    private NutritionPlan nutritionPlan;

}
