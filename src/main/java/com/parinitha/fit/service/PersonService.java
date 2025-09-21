package com.parinitha.fit.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.parinitha.fit.model.Person;
import com.parinitha.fit.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Person registerUser(Person person) {
        person.setPwd(passwordEncoder.encode(person.getPwd()));
        person.setRoles("ROLE_USER");
        return personRepository.save(person);
    }
}

