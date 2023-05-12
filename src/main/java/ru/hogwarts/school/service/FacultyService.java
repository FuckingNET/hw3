package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    Logger logger = LoggerFactory.getLogger(FacultyService.class);

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        logger.info("Was invoked method for create faculty");
        return facultyRepository.save(faculty);
    }

    public Faculty add(String name, String color) {
        logger.info("Was invoked method for add faculty by name and color");
        Faculty newFaculty = new Faculty(name, color);
        newFaculty = facultyRepository.save(newFaculty);
        return newFaculty;
    }

    public Faculty getFaculty(Long id) {
        logger.info("Was invoked method for find faculty");
        return facultyRepository.findById(id).get();
    }

    public List<Faculty> getAll() {
        return facultyRepository.findAll()
                .stream()
                .sorted((x, y) -> x.getColor().compareTo(y.getColor()))
                .collect(Collectors.toList());
    }

    public Faculty updateFaculty(Faculty faculty) {
        logger.info("Was invoked method for update faculty");
        return facultyRepository.save(faculty);
    }

    public void removeFaculty(Long id) {
        logger.info("Was invoked method for delete faculty");
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> filterFaculty(String color) {
        logger.info("Was invoked method for filter faculty by color");
        return facultyRepository.findAllByColorLike(color);
    }

    public Collection<Faculty> filterFaculty(String color, String name) {
        logger.info("Was invoked method for filter faculty by color and name");
        return facultyRepository.findFacultiesByColorIgnoreCaseOrNameIgnoreCase(color, name);
    }

    public Faculty findFacultyByStudent(String name) {
        logger.info("Was invoked method for find faculty by student");
        return facultyRepository.findFacultyByStudents_Name(name);
    }

}
