package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findAllByAge(int age);

    Collection<Student> findStudentsByAgeBetween(int min, int max);

    Optional<Student> findById(Long id);

    Collection<Student> findStudentsByFaculty_Name(String faculty);
}
