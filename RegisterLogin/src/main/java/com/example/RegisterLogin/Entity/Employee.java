package com.example.RegisterLogin.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "employee", uniqueConstraints = {
        @UniqueConstraint(columnNames = "employee_email")
})
@Data
public class Employee {
    @Id
    @GeneratedValue
    @Column(name = "employee_id", columnDefinition = "BINARY(16)")
    private UUID id;
    @Column(name="employee_name",length=100)
    private String name;
    @Column(name="employee_email",length=100,unique = true)
    private String email;
    @Column(name="employee_password",length=100)
    private String password;


    public Employee() {}

    public Employee(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

}
