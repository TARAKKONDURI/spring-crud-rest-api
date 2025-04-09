package com.crud.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.mysql.MySqlOrder;
import com.crud.repo.OrderRepo;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class ProductController {
	
	@Autowired
	private OrderRepo e;

	@PostMapping(path = "/hello",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> placeOrder(@RequestBody MySqlOrder order) throws JsonProcessingException {
		UUID u = UUID.randomUUID();
		order.setOrderId(u.toString());
		e.save(order);
		return new ResponseEntity<String>("Order placed", HttpStatus.OK);
		
	}

}
