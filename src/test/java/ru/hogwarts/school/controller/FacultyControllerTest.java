package ru.hogwarts.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.FacultyCreationRequest;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FacultyController.class)
class FacultyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FacultyService facultyService;

    @Test
    void getAll_success() throws Exception {
        //Подготовка входных данных


        //Подготовка ожидаемого результата
        when(facultyService.getAll()).thenReturn(Collections.emptyList());

        //Начало теста
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/faculty/getAll")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void add_success() throws Exception {
        //Подготовка входных данных
        String name = "testName";
        String color = "testColor";
        FacultyCreationRequest request = new FacultyCreationRequest();
        request.setName(name);
        request.setColor(color);

        String jsonData = new ObjectMapper().writeValueAsString(request);

        //Подготовка ожидаемого результата
        when(facultyService.add(name, color)).thenReturn(new Faculty());

        //Начало теста
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/faculty")
                        .content(jsonData)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}