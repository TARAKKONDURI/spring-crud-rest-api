package com.crud.model.mysql;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MySqlOrder {

	@Id
	private String orderId;
	private String paymentMethod;

	public MySqlOrder(String orderId, String paymentMethod) {
		super();
		this.orderId = orderId;
		this.paymentMethod = paymentMethod;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public MySqlOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

}
