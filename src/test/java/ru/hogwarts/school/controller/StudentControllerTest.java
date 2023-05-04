package ru.hogwarts.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.model.StudentCreationRequest;
import ru.hogwarts.school.service.StudentService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    void addStudent() throws Exception {
        //Подготовка данных
        String name = "testName";
        int age = 15;
        StudentCreationRequest request = new StudentCreationRequest();
        request.setName(name);
        request.setAge(age);

        String jsonData = new ObjectMapper().writeValueAsString(request);

        //Подготовка результата
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        when(studentService.createStudent(student)).thenReturn(new Student());

        //Начало теста
        mockMvc.perform(MockMvcRequestBuilders
                .post("/student")
                .content(jsonData)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void editStudent() throws Exception {
        //Подготовка данных
        String name = "testName";
        int age = 10;
        StudentCreationRequest request = new StudentCreationRequest();
        request.setName(name);
        request.setAge(age);

        String jsonData = new ObjectMapper().writeValueAsString(request);

        //Подготовка результата
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        when(studentService.updateStudent(student)).thenReturn(new Student());

        //Начало теста
        mockMvc.perform(MockMvcRequestBuilders
                        .put("/student")
                        .content(jsonData)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
