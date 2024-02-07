package com.example.EmployeeManagementSystem.contract.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class EmployeeRequest {
    @NotBlank(message="name cannot be empty")
    private String name;
    @NotBlank(message = "email cannot be empty")
    private String email;
    private String department;
}
