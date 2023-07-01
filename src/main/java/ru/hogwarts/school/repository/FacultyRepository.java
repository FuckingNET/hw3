package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;
import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Collection<Faculty> findAllByColorLike(String color);

    Collection<Faculty> findFacultiesByColorIgnoreCaseOrNameIgnoreCase(String color, String name);

    List<Faculty> findFacultyByStudents_name(String name);
}
