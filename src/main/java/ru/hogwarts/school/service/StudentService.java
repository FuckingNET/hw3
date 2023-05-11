package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    Logger logger = LoggerFactory.getLogger(StudentService.class);

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student createStudent(Student student) {
        logger.info("Was invoked method for create student");
        return studentRepository.save(student);
    }

    public Student findStudent(Long id) {
        logger.info("Was invoked method for find student");
        return studentRepository.findById(id).get();
    }

    public Student updateStudent(Student student) {
        logger.info("Was invoked method for update student");
        return studentRepository.save(student);
    }

    public void removeStudent(Long id) {
        logger.info("Was invoked method for delete student");
        studentRepository.deleteById(id);
    }

    public Collection<Student> filterStudent(int age) {
        logger.info("Was invoked method for filter student by age");
        return studentRepository.findAllByAge(age);
    }

    public Collection<Student> findStudentBetween(int min, int max) {
        logger.info("Was invoked method for find student between min and max age");
        return studentRepository.findStudentsByAgeBetween(min, max);
    }

    public Collection<Student> findStudentsByFaculty(String faculty) {
        logger.info("Was invoked method for find students by faculty");
        return studentRepository.findStudentsByFaculty_Name(faculty);
    }

    public Collection<Student> sortStudents() {
        return studentRepository.findAll().stream()
                .filter(student -> student.getName().startsWith("А"))
                .sorted()
                .toList();
    }
}
