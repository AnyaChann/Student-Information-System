package com.sis.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "student_score_t")
public class StudentScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentScoreId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @Column(name = "score1", nullable = false)
    private Double score1;

    @Column(name = "score2", nullable = false)
    private Double score2;

    // Getter and Setter for student
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    // Getter and Setter for subject
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}