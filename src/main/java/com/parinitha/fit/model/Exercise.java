package com.parinitha.fit.model;

import java.util.*;

import jakarta.persistence.*;

@Entity
public class Exercise {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "exercises")
    private List<Person> persons = new ArrayList<>();
}
