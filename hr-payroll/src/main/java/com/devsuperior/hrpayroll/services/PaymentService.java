package com.devsuperior.hrpayroll.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.devsuperior.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	
	public Payment getPayment(Long workerId, Integer days) {
		return new Payment("asdf", new BigDecimal("200.0"), days);
	}
}
