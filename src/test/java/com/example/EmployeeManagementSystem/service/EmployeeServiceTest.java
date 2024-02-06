package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.contract.Request.EmployeeRequest;
import com.example.EmployeeManagementSystem.contract.Response.EmployeeResponse;
import com.example.EmployeeManagementSystem.controller.EmployeeController;
import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeServiceTest {
    @Autowired
    MockMvc mockMvc;
    @InjectMocks EmployeeService employeeService;
    @MockBean private EmployeeController employeeController;
    @MockBean private EmployeeRepository employeeRepository;
    @MockBean private ModelMapper modelMapper;

    @Test
    public void testAddEmployee() throws Exception {
        EmployeeRequest request = new EmployeeRequest();
        Employee expectedEmployee = Employee.builder()
                .name(request.getName())
                .email(request.getEmail())
                .department(request.getDepartment())
                .build();
        when(employeeRepository.save(any(Employee.class))).thenReturn(expectedEmployee);
        EmployeeResponse actualResponse = employeeService.addEmployee(request);
        EmployeeResponse expectedResponse = modelMapper.map(expectedEmployee, EmployeeResponse.class);
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testGetEmployeesById() throws Exception {
        Long id = 1L;
        Employee expectedEmployee = new Employee();
        when(employeeRepository.findById(id)).thenReturn(Optional.of(expectedEmployee));
        EmployeeResponse actualResponse = employeeService.getEmployeesById(id);
        EmployeeResponse expectedResponse = modelMapper.map(expectedEmployee, EmployeeResponse.class);
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testGetEmployeeByDepartment() throws Exception {
        String query = "Sales";
        List<Employee> expectedEmployees = new ArrayList<>();
        when(employeeRepository.findByDepartment(query)).thenReturn(expectedEmployees);
        List<EmployeeResponse> actualResponse = employeeService.getEmployeeByDepartment(query);
        List<EmployeeResponse> expectedResponse = expectedEmployees.stream()
                .map(employee -> modelMapper.map(employee, EmployeeResponse.class))
                .collect(Collectors.toList());
        assertEquals(expectedResponse, actualResponse);
    }


}
