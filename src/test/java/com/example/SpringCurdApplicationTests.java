package com.example;

import com.example.dao.Employee;
import com.example.repository.EmployeeRepository;
import com.example.services.EmployeeService;
import lombok.RequiredArgsConstructor;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import java.util.Optional;


@SpringBootTest
@RequiredArgsConstructor
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SpringCurdApplicationTests {

	@Autowired
	private EmployeeService empserv;

	@Autowired
	private EmployeeRepository emprepo;


	@Test
	public void getAll(){
		List<Employee> employees = empserv.getAllEmployeesData();
		System.out.println(employees);

		Assertions.assertThat(employees.size()).isGreaterThan(0);
	}
	@Test
	public void findAll(){
		List<Employee> emplist = emprepo.findAll();
		System.out.println(emprepo.findAll());
		Assertions.assertThat(emplist.size()).isGreaterThan(0);
	}

	@Test
	public void findEmployee(){
		Optional<Employee> emp = empserv.getEmployee(1l);
		System.out.println(emp.get());
		Employee e =null;
		if(emp.isPresent()){
			e = emp.get();
		}
		Assertions.assertThat(e).isNotNull();
	}

	@Test
	public void updateEmployee(){
		Employee emp = empserv.getEmployee(1l).get();
		emp.setName("Naveen Kumar");
		emprepo.save(emp);
		Assertions.assertThat(emp.getName()).isEqualTo("Naveen Kumar");
	}

	@Test
	public void saveEmployee(){
		Employee emp = Employee.builder()
				.name("Surendar")
				.gender("Male")
				.designation("Software")
				.salary(100000)
		.build();
		empserv.saveEmployeeData(emp);
		Assertions.assertThat(emp.getId()).isGreaterThan(0);

	}

}
