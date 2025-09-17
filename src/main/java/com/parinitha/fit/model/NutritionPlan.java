package com.parinitha.fit.model;

import jakarta.persistence.*;

@Entity
public class NutritionPlan {
    @Id
    @GeneratedValue
    private Long id;

    private String dietChart;  // simple string for now

    // ✅ OneToOne
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
