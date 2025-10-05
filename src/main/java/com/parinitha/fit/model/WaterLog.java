package com.parinitha.fit.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

@Data
@Entity
public class WaterLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Autowired
    @ManyToOne
    @JoinColumn(name = "personId")
    private Person person; 

    private LocalDate date; 

    private int amount; 

}

