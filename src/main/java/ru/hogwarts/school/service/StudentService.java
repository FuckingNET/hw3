package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final FacultyRepository facultyRepository;

    Logger logger = LoggerFactory.getLogger(StudentService.class);

    public StudentService(StudentRepository studentRepository, FacultyRepository facultyRepository) {
        this.studentRepository = studentRepository;
        this.facultyRepository = facultyRepository;
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

    public Collection<String> sortStudents() {
        return studentRepository.findAll()
                .stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("A"))
                .sorted()
                .collect(Collectors.toList());
    }

    public Double avgAge() {
        return studentRepository.findAll().stream()
                .mapToDouble(Student::getAge)
                .average()
                .orElse(0);
    }

    public String getLongestNameFaculty() {
        List<Faculty> facultyList = facultyRepository.findAll();
        ;
        return facultyList.stream()
                .map(Faculty::getName)
                .max(Comparator.comparingInt(String::length))
                .orElse("No name");
    }

    public Integer task4() {
        long start = System.currentTimeMillis();
        int result = Stream
                .iterate(1, a -> a + 1)
                .limit(100_000_000)
                .reduce(0, (a, b) -> a + b);
        long finish = System.currentTimeMillis();

        logger.info("result: {}, time: {}", result, finish - start);
        return result;
    }

    public Integer task4Par() {
        long start = System.currentTimeMillis();
        int result = Stream
                .iterate(1, a -> a + 1)
                .limit(100_000_000)
                .parallel()
                .reduce(0, (a, b) -> a + b);
        long finish = System.currentTimeMillis();

        logger.info("result: {}, time: {}", result, finish - start);
        return result;
    }
}
