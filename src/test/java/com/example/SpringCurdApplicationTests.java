package com.example;

import com.example.dao.Employee;
import com.example.repository.EmployeeRepository;
import com.example.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@RequiredArgsConstructor
class SpringCurdApplicationTests {

	@Autowired
	private EmployeeService empserv;

	@Autowired
	EmployeeRepository emprepo;


	/*@Test
	void contextLoads() {
	}
*/
	@Test
	public void getAll(){
		List<Employee> employees = empserv.getAllEmployeesData();
		System.out.println(employees);
		//Assertions.assertThat(employees.size()).isGreaterThan(0);
	}

	@Test
	public void findAll(){
	 System.out.println(emprepo.findAll());
	}

}
