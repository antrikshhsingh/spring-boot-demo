package com.antriksh.employeeservice.Service;

import com.antriksh.employeeservice.entity.Employee;

import java.util.Date;
import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(int employeeId);

    List<Employee> getEmployeesByDateOfJoining(Date date);
}
