package br.com.scottpilgrim.nanosense.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.scottpilgrim.nanosense.data.model.User;
import br.com.scottpilgrim.nanosense.services.UserServices;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServices services;
	
	@GetMapping
	public List<User> findAll(){
		return services.findAll();
	}
	
	@PostMapping
	public User create(@RequestBody User user){
		return services.create(user);
	}
	
	@PutMapping
	public User update(@RequestBody User user){
		return services.update(user);
	}
	
	@GetMapping("/{id}")
	public User findById(@PathVariable("id") Long id){
		return services.findById(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		services.delete(id);
		return ResponseEntity.ok().build();
	}
}
