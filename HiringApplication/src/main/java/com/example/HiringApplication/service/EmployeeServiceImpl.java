package com.example.HiringApplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HiringApplication.dao.DepartmentDao;
import com.example.HiringApplication.dao.EmployeeDao;
import com.example.HiringApplication.pojo.Department;
import com.example.HiringApplication.pojo.Employee;
import com.example.HiringApplication.repository.DepartmentRepository;
import com.example.HiringApplication.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	DepartmentRepository deptRepo;
	
	@Override
	public List<Employee> getAllEmployees() 
	{
		List<Employee> empList = new ArrayList<>();
		empRepo.findAll().forEach(e -> {
			Employee epojo = new Employee();
			empList.add(daoToPojo(epojo, e));
		});
		return empList;
	}

	@Override
	public Employee getEmployeeById(Integer id) 
	{
		Optional<EmployeeDao> empOp = empRepo.findById(id);
		EmployeeDao e = empOp.get();
		Employee epojo = new Employee();
		return daoToPojo(epojo, e);
	}

	@Override
	public void deleteEmployee(Integer id) 
	{
		EmployeeDao empDao = empRepo.findById(id).get();
		DepartmentDao deptDao = deptRepo.findById(empDao.getDepartment().getId()).get();
		empRepo.delete(empDao);
		deptDao.setStrength(empRepo.findByDepartment(deptDao).size());
		deptRepo.save(deptDao);
	}

	@Override
	public Employee createEmployee(Employee epojo) 
	{
		EmployeeDao empDao = new EmployeeDao();
		DepartmentDao deptDao = deptRepo.findById(epojo.getDepartment_id()).get();
		empDao.setDepartment(deptDao);
		empDao = pojoToDao(epojo, empDao);
		EmployeeDao employeeDao = empRepo.save(empDao);
		deptDao.setStrength(empRepo.findByDepartment(deptDao).size());
		deptRepo.save(deptDao);
		epojo.setId(employeeDao.getId());
		return epojo;
	}

	@Override
	public Employee updateEmployee(Employee e) 
	{
		EmployeeDao empDao = empRepo.findById(e.getId()).get();
		empDao = pojoToDao(e, empDao);
		empDao = empRepo.save(empDao);
		return daoToPojo(e, empDao);
	}

	@Override
	public List<Employee> findByDepartment(Department dept) 
	{
		
		return null;
	}

	public EmployeeDao pojoToDao(Employee ePojo,EmployeeDao empDao)
	{
		empDao.setId(ePojo.getId());
		empDao.setName(ePojo.getName());
		empDao.setEmail(ePojo.getEmail());
		empDao.setSalary(ePojo.getSalary());
		empDao.setDoB(ePojo.getDoB());
		return empDao;
	}
	
	public Employee daoToPojo(Employee ePojo,EmployeeDao empDao)
	{
		ePojo.setId(empDao.getId());
		ePojo.setName(empDao.getName());
		ePojo.setEmail(empDao.getEmail());
		ePojo.setSalary(empDao.getSalary());
		ePojo.setDoB(empDao.getDoB());
		ePojo.setDepartment_id(empDao.getDepartment().getId());
		return ePojo;
	}
}
