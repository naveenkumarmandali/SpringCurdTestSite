package com.example.controller;

import com.example.dao.Employee;
import com.example.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Value("${my.profile}")
    private  String profile;
    @Autowired
    private EmployeeService empserv;

    @GetMapping("/first_employee")
    public ResponseEntity firstEmployeeApi() {
        return new ResponseEntity("Hi, this is first rest api", HttpStatus.ACCEPTED);
    }

    @GetMapping("/findAll_employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
       System.out.println("Active Profile :"+profile);
        return new ResponseEntity(empserv.getAllEmployeesData(), HttpStatus.OK);
    }

    @GetMapping("/find_employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") long emp_id) {
        Optional<Employee> emp = empserv.getEmployee(emp_id);
        return new ResponseEntity<>(emp.get(), HttpStatus.OK);
    }
   @PutMapping("/update_employee")
    public ResponseEntity<Optional<Employee>> updateEmployee(@RequestBody Employee emp){
        return  new ResponseEntity<Optional<Employee>>(empserv.updateEmployee(emp),HttpStatus.OK);
    }

    @PostMapping("/save_employee")
    public ResponseEntity<Employee> saveData(@RequestBody Employee emp){
        return new ResponseEntity<>(empserv.saveEmployeeData(emp),HttpStatus.OK);
    }


}
