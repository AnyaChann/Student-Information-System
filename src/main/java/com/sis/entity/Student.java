package com.sis.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_t")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @Column(name = "student_code", nullable = true, unique = true)
    private String studentCode;

    @Column(name = "full_name", nullable = true)
    private String fullName;

    // Custom constructor for DataInitializer
    public Student(String studentCode, String fullName) {
        this.studentCode = studentCode;
        this.fullName = fullName;
    }
    

    /**
     * @return Integer return the studentId
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    /**
     * @return String return the studentCode
     */
    public String getStudentCode() {
        return studentCode;
    }

    /**
     * @param studentCode the studentCode to set
     */
    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    /**
     * @return String return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}