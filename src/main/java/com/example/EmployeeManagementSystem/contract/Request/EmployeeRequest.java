package com.example.EmployeeManagementSystem.contract.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class EmployeeRequest {
    @NotBlank(message="name cannot be empty")
    private String name;
    @NotBlank(message = "email cannot be empty")
    private String email;
    private String department;
}
