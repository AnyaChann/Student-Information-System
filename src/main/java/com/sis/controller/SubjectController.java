package com.sis.controller;

import com.sis.entity.Subject;
import com.sis.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public String listSubjects(Model model) {
        List<Subject> subjects = subjectService.getAllSubjects();
        model.addAttribute("subjects", subjects);
        return "subject-list";
    }

    @GetMapping("/new")
    public String showSubjectForm(Model model) {
        model.addAttribute("subject", new Subject()); // Requires a no-argument constructor
        return "add-subject";
    }

    @PostMapping("/save")
    public String saveSubject(@ModelAttribute Subject subject) {
        subjectService.saveSubject(subject);
        return "redirect:/subjects";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Subject subject = subjectService.getSubjectById(id);
        model.addAttribute("subject", subject);
        return "add-subject";
    }

    @GetMapping("/delete/{id}")
    public String deleteSubject(@PathVariable("id") Integer id) {
        subjectService.deleteSubject(id);
        return "redirect:/subjects";
    }
}