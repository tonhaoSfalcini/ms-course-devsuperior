package com.devsuperior.hruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hruser.entities.User;
import com.devsuperior.hruser.repostories.UserRepository;


@RestController
@RequestMapping(value = "users")
public class UserResource {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		
		User w = userRepository.findById(id).get();
		
		return ResponseEntity.ok(w);
	}
	
	@GetMapping(value="/search")
	public ResponseEntity<User> findById(@RequestParam String email){

		User w = userRepository.findByEmail(email);
		
		return ResponseEntity.ok(w);
	}
}
