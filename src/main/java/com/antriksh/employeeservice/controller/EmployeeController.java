package com.antriksh.employeeservice.controller;

// EmployeeController.java

import com.antriksh.employeeservice.Service.EmployeeService;
import com.antriksh.employeeservice.annotations.RateLimit;
import com.antriksh.employeeservice.entity.Employee;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
        Employee addedEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(addedEmployee, HttpStatus.CREATED);
    }

    //Get all students
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // Get student by ID
    @GetMapping("/{employeeId}")
    @RateLimit(requestPerSecond = 2, message = "You can only request this endpoint twice per second.")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(required = true) int employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        return (employee != null) ? new ResponseEntity<>(employee, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Get student by Date of Joining
    @GetMapping("/byDateOfJoining/{date}")
    public ResponseEntity<List<Employee>> getEmployeesByDateOfJoining(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        List<Employee> employees = employeeService.getEmployeesByDateOfJoining(date);
        return (employees != null && !employees.isEmpty())
                ? new ResponseEntity<>(employees, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

