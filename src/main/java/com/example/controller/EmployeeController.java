package com.example.controller;

import com.example.dao.Employee;
import com.example.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService emp;

    @GetMapping("/firstEmployeeApi")
    public ResponseEntity firstEmployeeApi(){
        return new ResponseEntity("Hi, this is first rest api", HttpStatus.ACCEPTED);
    }

    @GetMapping("/findAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity(emp.getAllEmployeesData(),HttpStatus.OK);
    }

}
