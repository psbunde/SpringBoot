package com.example.HiringApplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.HiringApplication.dao.DepartmentDao;

public interface DepartmentRepository extends CrudRepository<DepartmentDao, Integer>
{
	
}
