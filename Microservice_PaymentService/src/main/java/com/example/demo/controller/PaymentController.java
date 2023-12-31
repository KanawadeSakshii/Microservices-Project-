package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Payment;
import com.example.demo.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/dopayment")
	public Payment doPayment(@RequestBody Payment payment) {
		return paymentService.doPayment(payment);
		//when payment object save to db that time we will map the order id
	}
	
	@GetMapping("/{orderId}")
    public Payment findPaymentHistoryByOrderId(@PathVariable int orderId) {
    	return paymentService.findPaymentHistoryByOrderId(orderId);
	}
	
}
