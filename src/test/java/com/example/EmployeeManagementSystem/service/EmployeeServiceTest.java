package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.contract.request.EmployeeRequest;
import com.example.EmployeeManagementSystem.contract.response.EmployeeResponse;
import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private ModelMapper modelMapper;

    @Test
    public void testAddEmployee() {
        EmployeeRequest request = new EmployeeRequest("shyam","shym@gmail.com","java");
        Employee employee = Employee.builder()
                .name(request.getName())
                .email(request.getEmail())
                .department(request.getDepartment())
                .build();

        EmployeeResponse expectedResponse = new EmployeeResponse(1L,"shyam","shyam@gmail.com","java");


        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
        when(modelMapper.map(employee, EmployeeResponse.class)).thenReturn(expectedResponse);

        EmployeeResponse actualResponse = employeeService.addEmployee(request);

        assertEquals(expectedResponse, actualResponse);
    }
    @Test
    public void testGetEmployeesById() {
        Long id = 1L;

        Employee employee = Employee.builder()
                .name("John Doe")
                .email("john.doe@example.com")
                .department("Engineering")
                .build();

        EmployeeResponse expectedResponse = new EmployeeResponse(1L,"shyam","shyam@edstem.com","java");

        when(employeeRepository.findById(id)).thenReturn(Optional.of(employee));
        when(modelMapper.map(employee, EmployeeResponse.class)).thenReturn(expectedResponse);

        EmployeeResponse actualResponse = employeeService.getEmployeesById(id);
        assertEquals(expectedResponse, actualResponse);
    }
    @Test
    public void testGetEmployeeByDepartment() {
        String query = "Engineering";

        Employee employee = Employee.builder()
                .name("SHYAM")
                .email("shyam@gmaill.com")
                .department(query)
                .build();

        List<Employee> employees = new ArrayList<>();
        employees.add(employee);

        EmployeeResponse expectedResponse = new EmployeeResponse(1L,"shyam","shyam@gmail.com","java");
        List<EmployeeResponse> expectedResponses = new ArrayList<>();
        expectedResponses.add(expectedResponse);

        when(employeeRepository.findByDepartment(query)).thenReturn(employees);
        when(modelMapper.map(employee, EmployeeResponse.class)).thenReturn(expectedResponse);

        List<EmployeeResponse> actualResponses = employeeService.getEmployeeByDepartment(query);

        assertEquals(expectedResponses, actualResponses);
    }
}
