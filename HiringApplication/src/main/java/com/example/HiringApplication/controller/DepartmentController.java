package com.example.HiringApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.HiringApplication.pojo.Department;
import com.example.HiringApplication.service.DepartmentService;

@RestController
public class DepartmentController 
{
	@Autowired
	DepartmentService deptService;
	
	@GetMapping("/Department")
	public List<Department> getAllDepartments()
	{
		System.out.println("Inside getAllDepartments");
		return deptService.getAllDepartments();
	}
	
	@GetMapping("/Department/{id}")
	public Department getDepartmentById(@PathVariable int id)
	{
		System.out.println("Inside getDepartmentById");
		return deptService.getDepartmentById(id);
	}
	
	@DeleteMapping("/Department/{id}")
	public void deleteEmployee(@PathVariable int id)
	{
		System.out.println("inside Delete Department");
		deptService.deleteDepartment(id);
	}
	
	@PostMapping("/Department")
	public Department createDepartment(@RequestBody Department d)
	{
		System.out.println("Inside create Department");
		return deptService.createDepartment(d);
	}
	
	@PutMapping("/Department")
	public Department updateEmployee(@RequestBody Department d)
	{
		System.out.println("Inside Update Department");
		return deptService.updateDepartment(d);
	}

	
}
