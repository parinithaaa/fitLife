package com.parinitha.fit.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;

    private String roleName;

}
