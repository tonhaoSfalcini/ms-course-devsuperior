package com.devsuperior.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	WorkerRepository workerRepository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = workerRepository.findAll();
		
		return ResponseEntity.ok(list);
	}

	@GetMapping(value="/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		Worker w = workerRepository.findById(id).get();
		
		return ResponseEntity.ok(w);
	}
}
