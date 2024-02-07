package com.example.EmployeeManagementSystem.contract.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeResponse {
    private Long id;
    private String name;
    private String email;
    private String department;
}
