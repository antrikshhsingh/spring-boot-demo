package com.antriksh.employeeservice.Service;

import com.antriksh.employeeservice.entity.Employee;
import com.antriksh.employeeservice.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(@Valid Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        if (employeeId <= 0 || employeeRepository.findById(employeeId).isEmpty()) {
            throw new IllegalArgumentException("Employee not found");
        }
        return employeeRepository.findById(employeeId).orElse(null);
    }

    @Override
    public List<Employee> getEmployeesByDateOfJoining(Date date) {
        return employeeRepository.findByEmployeeDateOfJoining(date);
    }

}
