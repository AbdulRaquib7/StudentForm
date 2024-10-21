package com.collegeform.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collegeform.application.model.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}