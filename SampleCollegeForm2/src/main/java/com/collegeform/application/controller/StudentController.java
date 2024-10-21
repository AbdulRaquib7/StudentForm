package com.collegeform.application.controller;

import com.collegeform.application.service.StudentService;
import com.collegeform.application.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Show the student form
    @GetMapping("/form")
    public String showStudentForm(Model model) {
        model.addAttribute("student", new Student()); // Bind an empty Student object to the form
        return "student-form"; // Return the name of the HTML file (student-form.html)
    }

    // Handle form submission and save the student
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student); // Save the student using the service layer
        return "redirect:/students/all"; // Redirect to the students list after saving
    }

    // Get all students and display them
    @GetMapping("/all")
    public String getAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students-list"; // Return the name of the HTML file displaying all students
    }
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id); // Delete the student by ID
        return "redirect:/students/all"; // Redirect to the students list after deletion
    }
}
