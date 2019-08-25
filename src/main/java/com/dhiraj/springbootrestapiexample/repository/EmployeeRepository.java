package com.dhiraj.springbootrestapiexample.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dhiraj.springbootrestapiexample.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
