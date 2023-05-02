package com.awsscreat.exmaple.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Table(name = "employee")
@Entity
@Getter
@Setter
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;


}