package com.antriksh.employeeservice.Service;

import com.antriksh.employeeservice.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface EmployeeServiceFeignClient {

    @GetMapping("/employees/{employeeId}")
    Employee getEmployeeById(@PathVariable Long employeeId);
}
