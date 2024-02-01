package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.contract.Request.EmployeeRequest;
import com.example.EmployeeManagementSystem.contract.Response.EmployeeResponse;
import com.example.EmployeeManagementSystem.controller.EmployeeController;
import com.example.EmployeeManagementSystem.model.Employee;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ServiceTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean private EmployeeController employeeController;

    @Test
    void testaddEmployee() throws  Exception{
        EmployeeRequest request = new EmployeeRequest();
        Employee employee = modelmapper.map(employee,EmployeeResponse.class)

    }

}
