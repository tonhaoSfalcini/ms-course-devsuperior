package com.devsuperior.hrpayroll.resources;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

	@Autowired
	private PaymentService paymentService;
	
	@HystrixCommand(fallbackMethod = "getPàymentAlternative")
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
		Payment payment = paymentService.getPayment(workerId, days);
		
		return ResponseEntity.ok(payment);
	}
	
	public ResponseEntity<Payment> getPàymentAlternative(Long workerId, Integer days){
		Payment pay = new Payment("Brann", new BigDecimal(400.0), days);
		return ResponseEntity.ok(pay);
	}
	
}
