package com.example.HiringApplication.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.HiringApplication.pojo.Department;

import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class EmployeeDao 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String email;
	private Long salary;
	private String DoB;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private DepartmentDao department;
	
}
