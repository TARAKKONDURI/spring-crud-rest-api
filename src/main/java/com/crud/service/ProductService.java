package com.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entity.Department;
import com.crud.entity.Employee;
import com.crud.repo.DeptRep;
import com.crud.repo.EmployeeRepo;

import jakarta.transaction.Transactional;

@Service
public class ProductService {
	
	@Autowired
	private DeptRep deptRepo;
	
	@Autowired
	private EmployeeRepo empRepo;
	
	@Transactional
	public void saveDetails(Employee e, Department d) throws Exception {
		
		Employee save = empRepo.save(e);
		System.out.println("EMployee id "+save.getId());
		if(false) {
			throw new Exception("Vara");
		}
		
		
		Department save2 = deptRepo.save(d);
		System.out.println("Emp id "+save2.getEmpId()+" dept id "+save2.getId());
		
	}

}
