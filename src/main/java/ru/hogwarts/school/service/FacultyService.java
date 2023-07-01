package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty add(String name, String color) {
        Faculty newFaculty = new Faculty(name, color);
        newFaculty = facultyRepository.save(newFaculty);
        return newFaculty;
    }

    public Faculty getFaculty(Long id) {
        return facultyRepository.findById(id).get();
    }

    public List<Faculty> getAll() {
        return facultyRepository.findAll()
                .stream()
                .sorted((x, y) -> x.getColor().compareTo(y.getColor()))
                .collect(Collectors.toList());
    }

    public Faculty updateFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void removeFaculty(Long id) {
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> filterFaculty(String color) {
        return facultyRepository.findAllByColorLike(color);
    }

    public Collection<Faculty> filterFaculty(String color, String name) {
        return facultyRepository.findFacultiesByColorIgnoreCaseOrNameIgnoreCase(color, name);
    }

    public List<Faculty> findFacultyByStudent(String name) {
        return facultyRepository.findFacultyByStudents_name(name);
    }

}
