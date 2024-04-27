package com.example.dao;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CollectionId;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="empid")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="gender")
    private String gen;

    @Column(name="desig")
    private  String designation;

    @Column(name="salary")
    private float salary;

}
