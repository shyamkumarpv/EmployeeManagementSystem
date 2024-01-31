package com.example.EmployeeManagementSystem.contract.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
    private String name;
    private String email;
    private String department;
}
