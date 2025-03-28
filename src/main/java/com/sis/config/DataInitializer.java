package com.sis.config;

import com.sis.entity.Student;
import com.sis.entity.Subject;
import com.sis.entity.StudentScore;
import com.sis.repository.StudentRepository;
import com.sis.repository.SubjectRepository;
import com.sis.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @PostConstruct
    public void initializeData() {
        // Add example students if the table is empty
        if (studentRepository.count() == 0) {
            List<Student> students = Arrays.asList(
                new Student("S001", "Nguyễn Văn A"),
                new Student("S002", "Trần Thị B"),
                new Student("S003", "Lê Văn C"),
                new Student("S004", "Phạm Thị D"),
                new Student("S005", "Hoàng Văn E"),
                new Student("S006", "Nguyễn Thị F"),
                new Student("S007", "Đặng Văn G"),
                new Student("S008", "Vũ Thị H"),
                new Student("S009", "Bùi Văn I"),
                new Student("S010", "Phan Thị J")
            );
            studentRepository.saveAll(students);
        }

        // Add example subjects if the table is empty
        if (subjectRepository.count() == 0) {
            List<Subject> subjects = Arrays.asList(
                new Subject("IT001", "Java Programming", 4),
                new Subject("IT002", "Web Development", 3),
                new Subject("IT003", "Database Systems", 3),
                new Subject("IT004", "Software Engineering", 4),
                new Subject("IT005", "Computer Networks", 3),
                new Subject("IT006", "Operating Systems", 3),
                new Subject("IT007", "Data Structures", 4),
                new Subject("IT008", "Machine Learning", 3),
                new Subject("IT009", "Cybersecurity", 3),
                new Subject("IT010", "Cloud Computing", 3)
            );
            subjectRepository.saveAll(subjects);
        }

        // Add example scores if the table is empty
        if (scoreRepository.count() == 0) {
            List<Student> students = studentRepository.findAll();
            List<Subject> subjects = subjectRepository.findAll();

            // Ensure there are enough students and subjects
            if (students.size() < 10 || subjects.size() < 10) {
                System.err.println("Not enough students or subjects to initialize scores.");
                return;
            }

            // Example scores for the first 10 students and first 10 subjects
            List<StudentScore> scores = Arrays.asList(
                new StudentScore(students.get(0), subjects.get(0), 8.5, 9.0),
                new StudentScore(students.get(1), subjects.get(1), 7.0, 8.0),
                new StudentScore(students.get(2), subjects.get(2), 6.5, 7.5),
                new StudentScore(students.get(3), subjects.get(3), 9.0, 9.5),
                new StudentScore(students.get(4), subjects.get(4), 5.0, 6.0),
                new StudentScore(students.get(5), subjects.get(5), 7.5, 8.5),
                new StudentScore(students.get(6), subjects.get(6), 6.0, 7.0),
                new StudentScore(students.get(7), subjects.get(7), 8.0, 8.5),
                new StudentScore(students.get(8), subjects.get(8), 9.5, 9.0),
                new StudentScore(students.get(9), subjects.get(9), 4.5, 5.5)
            );
            scoreRepository.saveAll(scores);
        }
    }
}