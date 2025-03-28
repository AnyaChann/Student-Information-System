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

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID: " + id));
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudentById(Integer id) {
        studentRepository.deleteById(id);
    }
}