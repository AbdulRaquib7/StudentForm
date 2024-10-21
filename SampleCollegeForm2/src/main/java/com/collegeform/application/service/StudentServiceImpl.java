package com.collegeform.application.service;

import com.collegeform.application.model.Student;
import com.collegeform.application.dao.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll(); // Fetch all students from the database
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student); // Save the student to the database
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }


    @Override
    public Student updateStudent(Long id, Student updatedStudent) {
        Student existingStudent = getStudentById(id);
        
        // Update student details
        existingStudent.setFirstName(updatedStudent.getFirstName());
        existingStudent.setLastName(updatedStudent.getLastName());
        existingStudent.setAge(updatedStudent.getAge());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setDob(updatedStudent.getDob());
        existingStudent.setTenthMarksPercentage(updatedStudent.getTenthMarksPercentage());
        existingStudent.setTwelfthMarksPercentage(updatedStudent.getTwelfthMarksPercentage());
        existingStudent.setCollegeCGPA(updatedStudent.getCollegeCGPA());

        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
