package br.com.scottpilgrim.nanosense.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.scottpilgrim.nanosense.model.SensorDevice;
import br.com.scottpilgrim.nanosense.services.SensorDeviceServices;


@RestController
@RequestMapping("/device")
public class SensorDeviceController {

	@Autowired
	private SensorDeviceServices services;
	
	@PutMapping
	public SensorDevice update(@RequestBody SensorDevice sensorDevice){
		return services.update(sensorDevice);
	}
	
	@GetMapping("/{key}")
	public SensorDevice findByKey(@PathVariable("key") String key){
		return services.findByKey(key);
	}

	@DeleteMapping("/{key}")
	public ResponseEntity<?> delete(@PathVariable("key") String key){
		services.delete(key);
		return ResponseEntity.ok().build();
	}
}
