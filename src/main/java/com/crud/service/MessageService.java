package com.crud.service;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class MessageService {
	
	
	
	@PostConstruct
	public void test() {
		System.out.println("MessageService test() post construct");
	}
	
	public void sendMesaage() {
		getNotificationService().sendMessage();
	}

	@Lookup
	public  NotificationService getNotificationService() {
		return null;
	}
}
