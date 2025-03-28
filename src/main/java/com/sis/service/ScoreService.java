package com.sis.service;

import com.sis.entity.StudentScore;
import com.sis.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public StudentScore saveScore(StudentScore score) {
        return scoreRepository.save(score);
    }

    public List<StudentScore> getAllScores() {
        return scoreRepository.findAll();
    }
}