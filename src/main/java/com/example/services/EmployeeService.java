package com.example.services;

import com.example.dao.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository empRepo;


    public List<Employee> getAllEmployeesData() {

        return empRepo.findAll();
    }
}
