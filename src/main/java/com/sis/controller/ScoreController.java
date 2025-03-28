package com.sis.controller;

import com.sis.entity.Student;
import com.sis.entity.Subject;
import com.sis.entity.StudentScore;
import com.sis.service.ScoreService;
import com.sis.service.StudentService;
import com.sis.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/scores")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/new")
    public String showScoreForm(Model model) {
        List<Student> students = studentService.getAllStudents();
        List<Subject> subjects = subjectService.getAllSubjects();
        model.addAttribute("students", students);
        model.addAttribute("subjects", subjects);
        model.addAttribute("score", new StudentScore());
        return "add-score";
    }

    @PostMapping("/save")
    public String saveScore(@ModelAttribute StudentScore score, Model model) {
        if (score.getStudent() == null || score.getSubject() == null) {
            model.addAttribute("error", "Both student and subject must be selected.");
            List<Student> students = studentService.getAllStudents();
            List<Subject> subjects = subjectService.getAllSubjects();
            model.addAttribute("students", students);
            model.addAttribute("subjects", subjects);
            model.addAttribute("score", score);
            return "add-score";
        }

        scoreService.saveScore(score);
        return "redirect:/students";
    }
}