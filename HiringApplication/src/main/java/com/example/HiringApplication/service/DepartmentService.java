package com.example.HiringApplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.HiringApplication.pojo.Department;

@Service
public interface DepartmentService
{

	List<Department> getAllDepartments();

	Department getDepartmentById(int id);

	void deleteDepartment(int id);

	Department createDepartment(Department d);

	Department updateDepartment(Department d);
	
}
