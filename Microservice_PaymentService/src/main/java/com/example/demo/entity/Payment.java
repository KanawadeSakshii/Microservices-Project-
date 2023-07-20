package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="payments")
public class Payment {

	@Id
	@GeneratedValue//(strategy = GenerationType.IDENTITY)
	private int paymentId;
	
	private String paymentStatus;
	private String tarnsactionId;
	
	private int orderId;
	private double amount;
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(String paymentStatus, String tarnsactionId) {
		super();
		this.paymentStatus = paymentStatus;
		this.tarnsactionId = tarnsactionId;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getTarnsactionId() {
		return tarnsactionId;
	}

	public void setTarnsactionId(String tarnsactionId) {
		this.tarnsactionId = tarnsactionId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Payment(String paymentStatus, String tarnsactionId, int orderId, double amount) {
		super();
		this.paymentStatus = paymentStatus;
		this.tarnsactionId = tarnsactionId;
		this.orderId = orderId;
		this.amount = amount;
	}

	
	
}

