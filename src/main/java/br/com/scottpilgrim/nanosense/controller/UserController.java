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

import br.com.scottpilgrim.nanosense.model.SensorDevice;
import br.com.scottpilgrim.nanosense.model.User;
import br.com.scottpilgrim.nanosense.services.SensorDeviceServices;
import br.com.scottpilgrim.nanosense.services.UserServices;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServices userServices;
	
	@Autowired
	private SensorDeviceServices deviceServices;
	
	@GetMapping
	public List<User> findAll(){
		return userServices.findAll();
	}
	
	@PostMapping
	public User create(@RequestBody User user){
		return userServices.create(user);
	}
	
	@PutMapping
	public User update(@RequestBody User user){
		return userServices.update(user);
	}
	
	@GetMapping("/{id}")
	public User findById(@PathVariable("id") Long id){
		return userServices.findById(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		userServices.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id}/device")
	public List<SensorDevice> getUserDevices(@PathVariable long id){
		return userServices.findById(id).getDevices();
	}

	@PostMapping("/{id}/device")
	public SensorDevice createUserDevice(@RequestBody SensorDevice device, @PathVariable("id") long userId){
		User owner = findById(userId);
		
		device.setOwner(owner);
		SensorDevice entityDevice = deviceServices.create(device);
		owner.getDevices().add(entityDevice);
		userServices.update(owner);
		return entityDevice;
	}

}
