package com.example.HiringApplication.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.HiringApplication.pojo.Employee;
import com.example.HiringApplication.service.EmployeeService;

@RestController
public class EmployeeController 
{
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/Employee")
	public List<Employee> getAllEmployees()
	{
		System.out.println("Inside getAllEmployees");
		return empService.getAllEmployees();
	}
	
	@GetMapping("/Employee/{id}")
	public Employee getEmployeeById(@PathVariable int id)
	{
		System.out.println("Inside getEmployeeById");
		return empService.getEmployeeById(id);
	}
	
	@DeleteMapping("/Employee/{id}")
	public void deleteEmployee(@PathVariable int id)
	{
		System.out.println("inside Delete Employee");
		empService.deleteEmployee(id);
	}
	
	@PostMapping("/Employee")
	public Employee createEmployee(@RequestBody @Valid Employee e)
	{
		System.out.println("Inside create Employee");
		return empService.createEmployee(e);
	}
	
	@PutMapping("/Employee")
	public Employee updateEmployee(@RequestBody Employee e)
	{
		System.out.println("Inside Update Employee");
		return empService.updateEmployee(e);
	}
	
	/* public List<Employee> findByDepartment(Department dept) */
	
	
}
