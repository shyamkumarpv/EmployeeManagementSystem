package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.contract.Request.EmployeeRequest;
import com.example.EmployeeManagementSystem.contract.Response.EmployeeResponse;
import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final ModelMapper modelMapper;
    private final EmployeeRepository employeeRepository;

    public EmployeeResponse addEmployee(EmployeeRequest request) {

        Employee employee = Employee.builder()
                .name(request.getName())
                .email(request.getEmail())
                .department(request.getDepartment())
                .build();
        employee = employeeRepository.save(employee);
        return modelMapper.map(employee, EmployeeResponse.class);
    }

    public List<EmployeeService> getAll() {
        List<Employee> employee = employeeRepository.findAll();
        return employee.stream()
                .map(employee1 -> modelMapper.map(employee1, EmployeeService.class))
                .collect(Collectors.toList());
    }

    public List<EmployeeResponse> getEmployeeByDepartment(String query) {
        List<Employee>employees = employeeRepository.findByDepartment(query);
        if (employees.isEmpty()) {
            throw new EntityNotFoundException("No data found");
        }
        return employees.stream()
                .map(employee -> modelMapper.map(employee, EmployeeResponse.class))
                .collect(Collectors.toList());
    }

}
