package com.sis.service;

import com.sis.entity.Subject;
import com.sis.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Subject getSubjectById(Integer id) {
        return subjectRepository.findById(id).orElse(null);
    }

    public void deleteSubject(Integer id) {
        subjectRepository.deleteById(id);
    }
}