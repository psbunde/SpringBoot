package com.example.HiringApplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.HiringApplication.pojo.Department;
import com.example.HiringApplication.pojo.Employee;

@Service
public interface EmployeeService 
{
	List<Employee> getAllEmployees();
	Employee getEmployeeById(Integer id);
	void deleteEmployee(Integer id);
	Employee createEmployee(Employee e);
	Employee updateEmployee(Employee e);
	List<Employee> findByDepartment(Department dept);
}
