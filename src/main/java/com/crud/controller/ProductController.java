package com.crud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@GetMapping(path = "/hello")
	public String hello() {
		return "hello, I am working...";
	}

}
