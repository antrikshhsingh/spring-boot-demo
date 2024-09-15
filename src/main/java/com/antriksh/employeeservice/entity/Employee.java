package com.antriksh.employeeservice.entity;

import com.antriksh.employeeservice.annotations.Capitalize;
import com.antriksh.employeeservice.annotations.Size;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "infy_employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @NotBlank(message = "Employee name is required")
    @Size(min = 5,max = 20,message = "must be between 5 and 20 characters")
    @Capitalize
    private String employeeName;

    @NotBlank(message = "Employee job is required")
    @Capitalize
    private String employeeJob;

    @NotNull(message = "Date of joining is required")
    @Temporal(TemporalType.DATE)
    private Date employeeDateOfJoining;

    @NotNull(message = "Employee salary is required")
    @PositiveOrZero(message = "Employee Salary must be zero or positive")
    private Double employeeSalary;

}
