package com.example.EmployeeManagementSystem.contract.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class EmployeeResponse {
    private Long Id;
    private String name;
    private String email;
    private String department;
}
