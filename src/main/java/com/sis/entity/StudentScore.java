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
    

    /**
     * @return Integer return the studentScoreId
     */
    public Integer getStudentScoreId() {
        return studentScoreId;
    }

    /**
     * @param studentScoreId the studentScoreId to set
     */
    public void setStudentScoreId(Integer studentScoreId) {
        this.studentScoreId = studentScoreId;
    }

    /**
     * @return Student return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * @return Subject return the subject
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    /**
     * @return Double return the score1
     */
    public Double getScore1() {
        return score1;
    }

    /**
     * @param score1 the score1 to set
     */
    public void setScore1(Double score1) {
        this.score1 = score1;
    }

    /**
     * @return Double return the score2
     */
    public Double getScore2() {
        return score2;
    }

    /**
     * @param score2 the score2 to set
     */
    public void setScore2(Double score2) {
        this.score2 = score2;
    }

}