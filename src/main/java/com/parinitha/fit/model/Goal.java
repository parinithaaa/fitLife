package com.parinitha.fit.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Goal {
    @Id
    @GeneratedValue
    private Long id;

    private String description;
    
    private String title;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
