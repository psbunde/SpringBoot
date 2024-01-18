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

@Service
public class DepartmentServiceImpl implements DepartmentService 
{
	
	@Autowired
	DepartmentRepository deptRepo;

	@Override
	public List<Department> getAllDepartments() {
		List<Department> deptList = new ArrayList<>();
		deptRepo.findAll().forEach(e -> {
			Department dpojo = new Department();
			deptList.add(daoToPojo(dpojo, e));
		});
		return deptList;
	}

	@Override
	public Department getDepartmentById(int id) {
		Optional<DepartmentDao> deptOp = deptRepo.findById(id);
		DepartmentDao d = deptOp.get();
		Department dpojo = new Department();
		return daoToPojo(dpojo, d);
		
	}

	@Override
	public void deleteDepartment(int id) 
	{
		DepartmentDao deptDao = deptRepo.findById(id).get();
		deptRepo.delete(deptDao);
	}

	@Override
	public Department createDepartment(Department d) 
	{
		DepartmentDao deptDao = new DepartmentDao();
		deptDao = pojoToDao(d, deptDao);
		DepartmentDao departmentDao = deptRepo.save(deptDao);
		d.setId(departmentDao.getId());
		return d;
	}

	@Override
	public Department updateDepartment(Department d) 
	{
		DepartmentDao deptDao = deptRepo.findById(d.getId()).get();
		deptDao = pojoToDao(d, deptDao);
		deptDao = deptRepo.save(deptDao);
		return daoToPojo(d, deptDao);
	}
	
	public DepartmentDao pojoToDao(Department dPojo,DepartmentDao deptDao)
	{
		deptDao.setId(dPojo.getId());
		deptDao.setDept_name(dPojo.getDept_name());
		deptDao.setLocation(dPojo.getLocation());
		deptDao.setStrength(dPojo.getStrength());
		return deptDao;
	}
	
	public Department daoToPojo(Department dPojo,DepartmentDao deptDao)
	{
		dPojo.setId(deptDao.getId());
		dPojo.setDept_name(deptDao.getDept_name());
		dPojo.setLocation(deptDao.getLocation());
		dPojo.setStrength(deptDao.getStrength());
		return dPojo;
	}

}
