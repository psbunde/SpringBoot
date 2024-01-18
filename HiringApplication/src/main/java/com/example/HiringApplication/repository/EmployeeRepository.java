package com.example.HiringApplication.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.HiringApplication.dao.DepartmentDao;
import com.example.HiringApplication.dao.EmployeeDao;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeDao, Integer>
{
	List<EmployeeDao> findByDepartment(DepartmentDao dept);
}
