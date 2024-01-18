package com.example.HiringApplication.pojo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Employee 
{
	private int id;

	@NotBlank(message = "Name is mandatory")
	private String name;
	
	@NotBlank(message = "Email is mandatory")
	private String email;
	
	@Min(30000)
	@Max(40000)
	private long salary;

	@NotBlank(message = "DoB is mandatory")
	private String DoB;
	
	@Min(1)
	@Max(3)
	private int department_id;
	
}
