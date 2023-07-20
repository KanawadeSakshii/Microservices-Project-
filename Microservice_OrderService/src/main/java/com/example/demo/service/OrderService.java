package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepository;
import com.example.demo.response.Payment;
import com.example.demo.response.TransactionRequest;
import com.example.demo.response.TransactionResponse;

@Service
public class OrderService {

	@Autowired
    private OrderRepository repository;
    
	@Autowired
    private RestTemplate template;
	
	 public TransactionResponse saveOrder(TransactionRequest request){
	        String response = "";
	        Order order = request.getOrder();
	        Payment payment = request.getPayment();
	        payment.setOrderId(order.getId());
	        payment.setAmount(order.getPrice());
	        //rest call with the help of resttamplate
	       // logger.info("Order-Service Request : "+new ObjectMapper().writeValueAsString(request));
	       //postForObject because in payment controller dopayment is postMapping 
	                                                         //http://localhost:9191/payment/dopayment
	        Payment paymentResponse = template.postForObject("http://PAYMENT-SERVICE/payment/dopayment", payment, Payment.class);
	        response = paymentResponse.getPaymentStatus().equals("success") ? "payment processing successful and order placed" : "there is a failure in payment api , order added to cart";
	        //logger.info("Order Service getting Response from Payment-Service : "+new ObjectMapper().writeValueAsString(response));
	        repository.save(order);
	        return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTarnsactionId(), response);
	    }
	}

