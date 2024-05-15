package com.example.emsbackendservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.emsbackendservice.records.EmployeeRecord;
import com.example.emsbackendservice.service.EmployeeService;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employees-by-department-name/{departmentName}")
    public ResponseEntity<List<EmployeeRecord>> getEmployeesByDepartmentName(@PathVariable("departmentName") String departmentName) {
        List<EmployeeRecord> employeeRecords = employeeService.getEmployeesByDepartmentName(departmentName);
        return new ResponseEntity<>(employeeRecords, HttpStatus.OK);
    }

    /** toggle field is to identify lessthan or graterthan */
    @GetMapping("/employees-by-salary/{salary}/{toggle}")
    public ResponseEntity<List<EmployeeRecord>> getEmployeesBySalary(@PathVariable("salary") Double salary,
            @PathVariable("toggle") boolean toggle) {
        List<EmployeeRecord> employeeRecords = employeeService.getEmployeesBySalary(salary, toggle);
       return new ResponseEntity<>(employeeRecords, HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeRecord>> getAllEmpoyeesAndDepartments() {
        List<EmployeeRecord> employeeRecords = employeeService.getAllEmployeeAndDepartments();
        return new ResponseEntity<>(employeeRecords, HttpStatus.OK);
    }
    
    
    
}
