package com.devsuperior.hrpayroll.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
public class Worker implements Serializable{

	private static final long serialVersionUID = 1L;

	@Getter
	private Long id;
	
	@Getter @Setter
	private String name;

	@Getter @Setter
	private BigDecimal dailyIncome;
	
}
