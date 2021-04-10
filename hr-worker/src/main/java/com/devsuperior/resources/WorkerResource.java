package com.devsuperior.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.entities.Worker;
import com.devsuperior.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	@Value("${test.config}")
	private String textConfig;
	
	@Autowired
	private Environment env;
	
	@Autowired
	WorkerRepository workerRepository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = workerRepository.findAll();
		
		return ResponseEntity.ok(list);
	}

	@GetMapping(value="/configs")
	public ResponseEntity<Void> getConfigs(){
		
		logger.info("CONFIG = "+textConfig);
		
		return ResponseEntity.noContent().build();
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		int x = 0;
		if(x==0) {
			try {
				Thread.sleep(3000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			throw new RuntimeException("fufu");
		}
		
		logger.info("PORT = "+env.getProperty("local.server.port"));

		Worker w = workerRepository.findById(id).get();
		
		return ResponseEntity.ok(w);
	}
}
