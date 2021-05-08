package dev.protobot.employeemanager.service;

import dev.protobot.employeemanager.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee (Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    Employee updateEmployee ( Employee employee);

    void deleteEmployeeById (Long id);



}
