package com.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.model.mysql.MySqlOrder;

@Repository
public interface OrderRepo extends JpaRepository<MySqlOrder, Integer>{

}
