package com.crud.service;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
@Scope(value = "prototype")
public class NotificationService {
	
	@PostConstruct
	public void test1() {
		System.out.println("MessageService test1() post construct");
	}
	
	public void sendMessage() {
		System.out.println("Sending message "+this);
	}
}
