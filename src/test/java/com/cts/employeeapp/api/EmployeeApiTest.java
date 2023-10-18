package com.cts.employeeapp.api;

import com.cts.employeeapp.model.Employee;
import com.cts.employeeapp.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(EmployeeApi.class)
public class EmployeeApiTest {

    @Autowired
    MockMvc mockMvc;


    @MockBean
    EmployeeService employeeService;

    // Test for Get All Employees
    @Test
    public void testGetAllEmployees() throws Exception {

        // create a list of employees
        List<Employee> employees = List.of(
                new Employee(1,"John", 42000, "Sales"),
                new Employee(2,"Jane", 45000, "Marketing"),
                new Employee(3,"Bob", 55000, "IT")
        );

        when(employeeService.getAllEmployees()).thenReturn(employees);
        mockMvc.perform(get("/api/employees/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].empName").value("John"))
                .andExpect(jsonPath("$[1].empName").value("Jane"))
                .andExpect(jsonPath("$[2].empName").value("Bob"));

        verify(employeeService, times(1)).getAllEmployees();


    }




}
