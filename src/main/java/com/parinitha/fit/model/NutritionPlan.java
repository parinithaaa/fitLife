package com.parinitha.fit.model;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
public class NutritionPlan {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mealType;   
    private String description;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @Setter
    private Person person;
}

