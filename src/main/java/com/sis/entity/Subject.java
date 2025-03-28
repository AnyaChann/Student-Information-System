package com.sis.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "subject_t")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subjectId;

    @Column(name = "subject_code", nullable = false, unique = true)
    private String subjectCode;

    @Column(name = "subject_name", nullable = false)
    private String subjectName;

    @Column(name = "credit", nullable = false)
    private Integer credit;
    

    /**
     * @return Integer return the subjectId
     */
    public Integer getSubjectId() {
        return subjectId;
    }

    /**
     * @param subjectId the subjectId to set
     */
    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * @return String return the subjectCode
     */
    public String getSubjectCode() {
        return subjectCode;
    }

    /**
     * @param subjectCode the subjectCode to set
     */
    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    /**
     * @return String return the subjectName
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * @param subjectName the subjectName to set
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * @return Integer return the credit
     */
    public Integer getCredit() {
        return credit;
    }

    /**
     * @param credit the credit to set
     */
    public void setCredit(Integer credit) {
        this.credit = credit;
    }

}