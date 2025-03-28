package com.sis.controller;

import com.sis.entity.Student;
import com.sis.entity.StudentScore;
import com.sis.service.StudentService;
import com.sis.util.GradeUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/new")
    public String showStudentForm(Model model) {
        model.addAttribute("student", new Student()); // Requires a no-argument constructor
        return "add-student";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String showEditStudentForm(@PathVariable("id") Integer id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "edit-student";
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student); // Save the updated student
        return "redirect:/students";
    }

        @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }

    @GetMapping
    public String listStudents(Model model) {
        List<Student> students = studentService.getAllStudents();

        // Extract scores and calculate grades for each student
        for (Student student : students) {
            List<StudentScore> scores = student.getScores(); // Fetch associated scores
            if (scores != null && !scores.isEmpty()) {
                // Use the first score for display (or modify logic as needed)
                StudentScore firstScore = scores.get(0);
                student.setScore1(firstScore.getScore1());
                student.setScore2(firstScore.getScore2());

                // Calculate grade if both scores are available
                if (firstScore.getScore1() != null && firstScore.getScore2() != null) {
                    String grade = GradeUtil.calculateGrade(firstScore.getScore1(), firstScore.getScore2());
                    student.setGrade(grade);
                } else {
                    student.setGrade("N/A");
                }
            } else {
                student.setScore1(null);
                student.setScore2(null);
                student.setGrade("N/A");
            }
        }

        model.addAttribute("students", students);
        return "index";
    }
}