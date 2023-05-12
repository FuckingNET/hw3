package ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = studentService.findStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
        Student student1 = studentService.updateStudent(student);
        if (student1 == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(student1);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id) {
        studentService.removeStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("filter")
    public ResponseEntity<Collection<Student>> filterStudent(@RequestParam int age) {
        return ResponseEntity.ok(studentService.filterStudent(age));
    }

    @GetMapping
    public ResponseEntity<Collection<Student>> findStudentBetween(@RequestParam int min,
                                                                  @RequestParam int max) {
        return ResponseEntity.ok(studentService.findStudentBetween(min, max));
    }

    @GetMapping("faculty/{faculty}")
    public ResponseEntity<Collection<Student>> findStudentsByFaculty(@PathVariable String faculty) {
        return ResponseEntity.ok(studentService.findStudentsByFaculty(faculty));
    }

    @GetMapping("sortByAlphabet")
    public ResponseEntity<Collection<String>> sortStudents() {
        return ResponseEntity.ok(studentService.sortStudents());
    }

    @GetMapping("avgAge")
    public ResponseEntity<Double> avgAgeStudents() {
        return ResponseEntity.ok(studentService.avgAge());
    }

    @GetMapping("longestNameFaculty")
    public ResponseEntity<String> longestNameFaculty() {
        return ResponseEntity.ok(studentService.getLongestNameFaculty());
    }

    @GetMapping("task-4")
    public Integer task4() {
        studentService.task4();
        studentService.task4Par();
        return 0;
    }

    @GetMapping("/printAll")
    public void printAll() {
        studentService.printAll();
    }

    @GetMapping("/printAllSync")
    public void printAllSync() {
        studentService.printAllSync();
    }
}
