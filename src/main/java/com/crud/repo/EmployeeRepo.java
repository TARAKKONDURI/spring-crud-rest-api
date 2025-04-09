package com.crud.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.crud.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	@Query(name = "findByName")
	List<Optional<Employee>> findByEmpName(@Param(value = "name") String name);

}
