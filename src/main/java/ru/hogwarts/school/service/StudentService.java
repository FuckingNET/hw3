package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudent(Long id) {
        return studentRepository.findById(id).get();
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void removeStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> filterStudent(int age) {
        return studentRepository.findAllByAge(age);
    }

    public Collection<Student> findStudentBetween(int min, int max) {
        return studentRepository.findStudentsByAgeBetween(min, max);
    }

    public Collection<Student> findStudentsByFaculty(String faculty) {
        return studentRepository.findStudentsByFaculty_Name(faculty);
    }
}
