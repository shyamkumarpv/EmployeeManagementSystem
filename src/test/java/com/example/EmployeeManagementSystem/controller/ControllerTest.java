package com.example.EmployeeManagementSystem.controller;

import com.example.EmployeeManagementSystem.contract.Request.EmployeeRequest;
import com.example.EmployeeManagementSystem.contract.Response.EmployeeResponse;
import com.example.EmployeeManagementSystem.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
    @Autowired MockMvc mockMvc;
    @MockBean private EmployeeService employeeService;

    @Test
    void testaddEmployee() throws Exception {
        EmployeeRequest request = new EmployeeRequest();
        request.setName("shyam");
        request.setEmail("shyam@gmail.com");
        request.setDepartment("java");

        EmployeeResponse response = new EmployeeResponse();
        response.setId(1L);
        response.setName("shyam");
        response.setEmail("shyam@gmail.com");
        response.setDepartment("java");

    }
    @Test
    void testgetEmployeesById() throws Exception{
        EmployeeResponse response = new EmployeeResponse();
        response.setId(2L);
        response.setName("jithin");
        response.setEmail("jithin@gmail.com");
        response.setDepartment("python");

        Mockito.when(employeeService.getEmployeesById(2l)).thenReturn(response);

    }
    @Test
    void getEmployeeByDepartment() throws Exception{
        List<EmployeeResponse>responseList = new ArrayList<>();
        Mockito.when(employeeService.getEmployeeByDepartment("python")).thenReturn(responseList);

    }

    }





