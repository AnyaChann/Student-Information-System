package com.sis.repository;

import com.sis.entity.StudentScore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<StudentScore, Integer> {
}