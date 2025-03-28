package com.sis.service;

import com.sis.entity.Student;
import com.sis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
        public Student getStudentById(Integer id) {
        return studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student ID: " + id));
    }
}