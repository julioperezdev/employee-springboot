package dev.protobot.employeemanager.controller;

import dev.protobot.employeemanager.dto.response.RestResponse;
import dev.protobot.employeemanager.model.Employee;
import dev.protobot.employeemanager.service.implementation.EmployeeServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeServiceImplementation employeeServiceImplementation;


    @Autowired
    public EmployeeController(EmployeeServiceImplementation employeeServiceImplementation) {
        this.employeeServiceImplementation = employeeServiceImplementation;
    }

    @GetMapping("/all")
    RestResponse<List<Employee>> getAllEmployees (){
        List<Employee> employees = employeeServiceImplementation.getAllEmployees();
        return new RestResponse<>(HttpStatus.OK, employees);
    }

    @GetMapping("/find/{id}")
    RestResponse<Employee> getEmployeeById (@PathVariable("id") Long id){
        Employee employee = employeeServiceImplementation.getEmployeeById(id);
        return new RestResponse<>(HttpStatus.OK, employee);
    }

    @PostMapping("/add")
    RestResponse<Employee> addEmployee (@RequestBody Employee employee){
        Employee employeeSaved = employeeServiceImplementation.addEmployee(employee);
        return new RestResponse<>(HttpStatus.CREATED, employeeSaved);
    }

    @DeleteMapping("/delete/{id}")
    RestResponse<?> deleteEmployeeById(@PathVariable("id") Long id){
        employeeServiceImplementation.deleteEmployeeById(id);
        return new RestResponse<>(HttpStatus.OK, "Employee was deleted");
    }

    @PutMapping("/update")
    RestResponse<Employee> updateEmployeeById (@RequestBody Employee employee){
        Employee employeeUpdated = employeeServiceImplementation.updateEmployee(employee);
        return new RestResponse<>(HttpStatus.OK, employeeUpdated);
    }


}
