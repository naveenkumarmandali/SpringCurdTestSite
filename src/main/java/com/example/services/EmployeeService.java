package com.example.services;

import com.example.dao.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository empRepo;


    public List<Employee> getAllEmployeesData() {

        return empRepo.findAll();
    }

    public Optional<Employee> getEmployee(long id) {

        return empRepo.findById(id);
    }

    public Optional<Employee> updateEmployee(Employee emp) {

        Optional<Employee> data = empRepo.findById(emp.getId());
        Employee e = data.get();
        e.setName(emp.getName());
        e.setGender(emp.getGender());
        e.setDesignation(emp.getDesignation());
        e.setSalary(emp.getSalary());
        empRepo.save(e);
        return Optional.of(e);
    }

    public Employee saveEmployeeData(Employee emp) {
        return empRepo.save(emp);
    }
}
