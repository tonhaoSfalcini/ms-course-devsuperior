package com.devsuperior.hrpayroll.entities;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Payment {

	private String name;
	private BigDecimal dailyIncome;
	private Integer days;

	public BigDecimal getTotal() {
		return dailyIncome.multiply(new BigDecimal(days));
	}
}
