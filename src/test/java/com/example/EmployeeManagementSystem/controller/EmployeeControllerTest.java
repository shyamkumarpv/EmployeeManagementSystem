package com.example.EmployeeManagementSystem.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import com.example.EmployeeManagementSystem.contract.request.EmployeeRequest;
import com.example.EmployeeManagementSystem.contract.response.EmployeeResponse;
import com.example.EmployeeManagementSystem.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @Test
    public void testAddEmployee() {
        EmployeeRequest request = new EmployeeRequest();
        EmployeeResponse expectedResponse = new EmployeeResponse();
        when(employeeService.addEmployee(request)).thenReturn(expectedResponse);

        EmployeeResponse actualResponse = employeeController.addEmployee(request);

        verify(employeeService).addEmployee(request);

        assertNotNull(actualResponse);
        assertEquals(expectedResponse, actualResponse);
    }
    @Test
    public void testGetEmployeesById() {
        Long id = 1L;
        EmployeeResponse expectedResponse = new EmployeeResponse();
        when(employeeService.getEmployeesById(id)).thenReturn(expectedResponse);

        EmployeeResponse actualResponse = employeeController.getEmployeesById(id);

        verify(employeeService).getEmployeesById(id);

        assertNotNull(actualResponse);
        assertEquals(expectedResponse, actualResponse);
    }
    @Test
    public void testGetEmployeeByDepartment() {
        String query = "IT";
        List<EmployeeResponse> expectedResponse = new ArrayList<>();

        when(employeeService.getEmployeeByDepartment(query)).thenReturn(expectedResponse);

        List<EmployeeResponse> actualResponse = employeeController.getEmployeeByDepartment(query);

        verify(employeeService).getEmployeeByDepartment(query);

        assertNotNull(actualResponse);
        assertEquals(expectedResponse, actualResponse);
    }
}


