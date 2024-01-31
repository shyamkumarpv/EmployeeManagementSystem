package com.example.EmployeeManagementSystem.controller;

import com.example.EmployeeManagementSystem.contract.Request.EmployeeRequest;
import com.example.EmployeeManagementSystem.contract.Response.EmployeeResponse;
import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public EmployeeResponse addEmployee(@RequestBody EmployeeRequest request){
        return employeeService.addEmployee(request);
    }
    @GetMapping("/{id}")
    public EmployeeResponse getEmployeesById(@PathVariable Long id){
        return employeeService.getEmployeesById(id);

    }
    @GetMapping("/department")
    public List<EmployeeResponse> getEmployeeByDepartment(@RequestParam("department") String query){
    return employeeService.getEmployeeByDepartment(query);

    }

}
