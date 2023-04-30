package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final Map<Long, Faculty> facultys = new HashMap<>();
    private long facultyId = 0;

    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(++facultyId);
        facultys.put(facultyId, faculty);
        return faculty;
    }

    public Faculty getFaculty(Long id) {
        return facultys.get(id);
    }

    public Faculty updateFaculty(Long id, Faculty faculty) {
        facultys.put(id, faculty);
        return faculty;
    }

    public Faculty removeFaculty(Long id) {
        return facultys.remove(id);
    }

    public Collection<Faculty> filterFaculty(String color) {
        return facultys.values().stream()
                .filter(faculty -> faculty.getColor().equals(color))
                .collect(Collectors.toList());
    }

}
