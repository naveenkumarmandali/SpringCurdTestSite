package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.Employee;
import com.example.services.EmployeeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Value("${my.profile}")
	private String profile;
	@Autowired
	private EmployeeService empserv;

	@GetMapping("/first_employee")
	public ResponseEntity firstEmployeeApi() {
		return new ResponseEntity("Hi, this is first rest api", HttpStatus.ACCEPTED);
	}

	@GetMapping("/findAll_employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		System.out.println("Active Profile :" + profile);
		return new ResponseEntity(empserv.getAllEmployeesData(), HttpStatus.OK);
	}

	@GetMapping("/find_employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") long emp_id) {
		System.out.println("Employee Id: " + emp_id);
		Employee emp = empserv.getEmployee(emp_id).get();

		return new ResponseEntity<Employee>(emp, HttpStatus.OK);

	}

	@PutMapping("/update_employee")
	public ResponseEntity<Optional<Employee>> updateEmployee(@RequestBody Employee emp) {
		return new ResponseEntity<Optional<Employee>>(empserv.updateEmployee(emp), HttpStatus.OK);
	}

	@PostMapping("/save_employee")
	public ResponseEntity<Employee> saveData(@RequestBody Employee emp) {
		return new ResponseEntity<>(empserv.saveEmployeeData(emp), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> softDelete(@PathVariable long id){
		System.out.println("Soft Delete id: "+id);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

}
