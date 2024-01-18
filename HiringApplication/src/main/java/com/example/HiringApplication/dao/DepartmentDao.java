package com.example.HiringApplication.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.HiringApplication.pojo.Employee;

import lombok.Data;

@Entity
@Table(name = "department")
@Data
public class DepartmentDao 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String dept_name;
	private String location;
	private int strength;
	
}
