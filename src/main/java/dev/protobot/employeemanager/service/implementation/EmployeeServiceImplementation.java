package dev.protobot.employeemanager.service.implementation;

import dev.protobot.employeemanager.exception.UserNotFoundException;
import dev.protobot.employeemanager.model.Employee;
import dev.protobot.employeemanager.respository.EmployeeRepository;
import dev.protobot.employeemanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.saveEmployee(
                employee.getName(),
                employee.getEmail(),
                employee.getJobTitle(),
                employee.getPhone(),
                employee.getEmployeeCode());
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.getEmployeesById(id)
                .orElseThrow(() ->
                        new UserNotFoundException("User by id :" + id + "was not found"));
    }


    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.updateEmployee(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getJobTitle(),
                employee.getPhone());
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }


}
