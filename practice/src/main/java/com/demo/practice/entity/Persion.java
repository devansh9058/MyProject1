package com.demo.practice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Persion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private int salary;
    private String department;
    private String phoneNo;

}
