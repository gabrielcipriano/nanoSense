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

import br.com.scottpilgrim.nanosense.dto.DataStreamExplicitDTO;
import br.com.scottpilgrim.nanosense.model.DataStream;
import br.com.scottpilgrim.nanosense.services.DataStreamServices;


@RestController
@RequestMapping("/stream")
public class DataStreamController {

	@Autowired
	private DataStreamServices services;
	
	@PutMapping
	public DataStream update(@RequestBody DataStream dataStream){
		return services.update(dataStream);
	}
	
	@GetMapping("/{key}")
	public DataStreamExplicitDTO findByKey(@PathVariable("key") String key){
		return services.findByKey(key);
	}

	@DeleteMapping("/{key}")
	public ResponseEntity<?> delete(@PathVariable("key") String key){
		services.delete(key);
		return ResponseEntity.ok().build();
	}
}
