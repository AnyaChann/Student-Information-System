package com.sis.controller;

import com.sis.entity.StudentScore;
import com.sis.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/scores")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping("/new")
    public String showScoreForm(Model model) {
        model.addAttribute("score", new StudentScore());
        return "add-score";
    }

    @PostMapping("/save")
    public String saveScore(@ModelAttribute StudentScore score) {
        scoreService.saveScore(score);
        return "redirect:/students";
    }
}