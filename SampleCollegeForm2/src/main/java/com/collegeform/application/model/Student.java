package com.collegeform.application.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "First name cannot be null")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    private String lastName;

    private Integer age; // Allows null value

    @Email(message = "Email should be valid")
    @NotNull(message = "Email cannot be null")
    private String email;

    @Column(name = "dob")
    private LocalDate dob;



    private Double tenthMarksPercentage; // Allows null value
    private Double twelfthMarksPercentage; // Allows null value
    private Double collegeCGPA; // Allows null value
    
    
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) { // Use Integer to accommodate null values
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dateOfBirth) {
        this.dob = dateOfBirth;
    }

    public Double getTenthMarksPercentage() {
        return tenthMarksPercentage;
    }

    public void setTenthMarksPercentage(Double tenthMarksPercentage) {
        this.tenthMarksPercentage = tenthMarksPercentage;
    }

    public Double getTwelfthMarksPercentage() {
        return twelfthMarksPercentage;
    }

    public void setTwelfthMarksPercentage(Double twelfthMarksPercentage) {
        this.twelfthMarksPercentage = twelfthMarksPercentage;
    }

    public Double getCollegeCGPA() {
        return collegeCGPA;
    }

    public void setCollegeCGPA(Double collegeCGPA) {
        this.collegeCGPA = collegeCGPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dob +
                ", tenthMarksPercentage=" + tenthMarksPercentage +
                ", twelfthMarksPercentage=" + twelfthMarksPercentage +
                ", collegeCGPA=" + collegeCGPA +
                '}';
    }
}
