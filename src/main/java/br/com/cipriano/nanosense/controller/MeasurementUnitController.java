package br.com.cipriano.nanosense.controller;


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

import br.com.cipriano.nanosense.model.MeasurementUnit;
import br.com.cipriano.nanosense.services.MeasurementUnitServices;


@RestController
@RequestMapping("/measurement-unit")
public class MeasurementUnitController {

	@Autowired
	private MeasurementUnitServices services;
	
	@GetMapping
	public List<MeasurementUnit> findAll(){
		return services.findAll();
	}
	
	@PostMapping
	public MeasurementUnit create(@RequestBody MeasurementUnit measurementUnit){
		return services.create(measurementUnit);
	}
	
	@PutMapping
	public MeasurementUnit update(@RequestBody MeasurementUnit measurementUnit){
		return services.update(measurementUnit);
	}
	
	@GetMapping("/{id}")
	public MeasurementUnit findById(@PathVariable("id") Long id){
		return services.findById(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		services.delete(id);
		return ResponseEntity.ok().build();
	}
}
