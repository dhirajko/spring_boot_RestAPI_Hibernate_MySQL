package com.dhiraj.springbootrestapiexample.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dhiraj.springbootrestapiexample.model.Employee;
import com.dhiraj.springbootrestapiexample.repository.EmployeeRepository;

@Service
public class EmployeeDAO {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee save (Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public List<Employee> findall(){
		return employeeRepository.findAll();
		}

	public Employee findone(Long id){
		return employeeRepository.findById(id).orElse(null);
		}
	
	public void delete(Employee employee) {
	 employeeRepository.delete(employee);	
	}
	
}
