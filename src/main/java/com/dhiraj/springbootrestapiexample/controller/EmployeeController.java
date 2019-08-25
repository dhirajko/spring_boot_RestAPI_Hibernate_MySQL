package com.dhiraj.springbootrestapiexample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dhiraj.springbootrestapiexample.dao.EmployeeDAO;
import com.dhiraj.springbootrestapiexample.model.Employee;

@RestController
//@RequestMapping("/company")
@ComponentScan(basePackages={"com.dhiraj"})
public class EmployeeController {

	@Autowired
	EmployeeDAO employeeDaAO;
	
	@GetMapping("/")
	public String check() {
		return "Hello World!";
	}

	/* Save empoloyee */
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		return employeeDaAO.save(employee);
	}

	/* get all empoloyees */
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeDaAO.findall();
	}

	/* get empoloyee by id */
	@GetMapping("/notes/{id}")
	public Employee getEmployeesById(@PathVariable(value = "id") Long id) {
		return employeeDaAO.findone(id);
	}

	/* Updating employee */
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long id,
			@Valid @RequestBody Employee employee) {
		Employee emp = employeeDaAO.findone(id);
		if (emp == null) {
			return ResponseEntity.notFound().build();
		}
		emp.setName(employee.getName());
		emp.setDesignation(employee.getDesignation());
		emp.setExperties(employee.getExperties());
		Employee updatedEmployee = employeeDaAO.save(emp);

		return ResponseEntity.ok().body(updatedEmployee);
	}

	/* Deleter Employee */
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value = "id") Long id) {
		Employee employee = employeeDaAO.findone(id);
		if (employee == null) {
			return ResponseEntity.notFound().build();
		}
		employeeDaAO.delete(employee);
		return ResponseEntity.ok().build();
	}

}