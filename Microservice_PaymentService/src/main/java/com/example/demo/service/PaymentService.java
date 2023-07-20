package com.example.demo.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Payment;
import com.example.demo.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

    public Payment doPayment(Payment payment) {
    	payment.setPaymentStatus(paymentProcessing());
	payment.setTarnsactionId(UUID.randomUUID().toString());
	return paymentRepository.save(payment);
}
   
    
    public String paymentProcessing() {
		//API should be 3rd party payment gateway(paym,)
		return new Random().nextBoolean()?"success":"false";
	}


	public Payment findPaymentHistoryByOrderId(int orderId) {
		
		Payment payment= paymentRepository.findByorderId(orderId);
		return payment ;
	} 
}
