package com.example.EmployeeManagementSystem.controller;

import com.example.EmployeeManagementSystem.contract.Request.EmployeeRequest;
import com.example.EmployeeManagementSystem.contract.Response.EmployeeResponse;
import com.example.EmployeeManagementSystem.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    private EmployeeService employeeService;
    @InjectMocks private EmployeeController employeeController;

    @Test
    public void testAddEmployee() throws Exception {
        EmployeeRequest request = new EmployeeRequest();
        EmployeeResponse expectedResponse = new EmployeeResponse();
        when(employeeService.addEmployee(request)).thenReturn(expectedResponse);
        EmployeeResponse actualResponse = employeeController.addEmployee(request);
        verify(employeeService, times(1)).addEmployee(request);
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testGetEmployeesById() throws Exception {
        Long id = 1L;
        EmployeeResponse expectedResponse = new EmployeeResponse();
        when(employeeService.getEmployeesById(id)).thenReturn(expectedResponse);
        EmployeeResponse actualResponse = employeeController.getEmployeesById(id);
        verify(employeeService, times(1)).getEmployeesById(id);
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testGetEmployeeByDepartment() throws Exception {
        String query = "Sales";
        List<EmployeeResponse> expectedResponse = new ArrayList<>();
        when(employeeService.getEmployeeByDepartment(query)).thenReturn(expectedResponse);
        List<EmployeeResponse> actualResponse = employeeController.getEmployeeByDepartment(query);
        verify(employeeService, times(1)).getEmployeeByDepartment(query);
        assertEquals(expectedResponse, actualResponse);
    }
}





