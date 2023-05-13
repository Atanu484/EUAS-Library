package com.example.employee.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data //So,we could use lombok
@Table(name = "employees")
// This is where the data would be saved to database.
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//We want to generate the value automatically and would be autoincrement
    private long id; //This is the primary key (@Id)
    private String firstName;
    private String lastName;
    private String emailId;
}
