package com.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.entity.Department;

@Repository
public interface DeptRep extends JpaRepository<Department, Integer>{

}
