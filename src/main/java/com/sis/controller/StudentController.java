package com.sis.controller;

import com.sis.entity.Student;
import com.sis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/new")
    public String showStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    public String calculateGrade(Double score1, Double score2) {
        double grade = (0.3 * score1) + (0.7 * score2);
        if (grade >= 8.0)
            return "A";
        else if (grade >= 6.0)
            return "B";
        else if (grade >= 4.0)
            return "D";
        else
            return "F";
    }

    @GetMapping
    public String listStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "student-list";
    }
}
