package com.devsuperior;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.entities.Worker;
import com.devsuperior.repositories.WorkerRepository;

@SpringBootApplication
public class HrWorkerApplication implements CommandLineRunner{

	@Autowired
	WorkerRepository workerRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(HrWorkerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Worker w1 = new Worker(null, "Bob", new BigDecimal("200.0"));
		Worker w2 = new Worker(null, "Maria", new BigDecimal("300.0"));
		Worker w3 = new Worker(null, "Alex", new BigDecimal("250.0"));
		
		workerRepository.saveAll(Arrays.asList(w1, w2, w3));
		
	}

	
}
