package com.parinitha.fit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parinitha.fit.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	    Person readByName(String name);  
	    Person findByEmail(String email); 
}
