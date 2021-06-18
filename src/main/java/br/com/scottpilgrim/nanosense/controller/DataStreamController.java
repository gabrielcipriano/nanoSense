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

import br.com.scottpilgrim.nanosense.dto.DataStreamExplicitDTO;
import br.com.scottpilgrim.nanosense.dto.SensorDataExplicitDTO;
import br.com.scottpilgrim.nanosense.model.DataStream;
import br.com.scottpilgrim.nanosense.model.SensorData;
import br.com.scottpilgrim.nanosense.services.DataStreamServices;
import br.com.scottpilgrim.nanosense.services.SensorDataServices;


@RestController
@RequestMapping("/stream")
public class DataStreamController {

	@Autowired
	private DataStreamServices services;
	
	@Autowired SensorDataServices sensorDataServices;
	
	@PutMapping
	public DataStream update(@RequestBody DataStream dataStream){
		return services.update(dataStream);
	}
	
	@GetMapping("/{key}")
	public DataStreamExplicitDTO findByKey(@PathVariable("key") String key){
		return services.findDTOByKey(key);
	}

	@DeleteMapping("/{key}")
	public ResponseEntity<?> delete(@PathVariable("key") String key){
		services.delete(key);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/{key}/measurement")
	public SensorDataExplicitDTO createSensorData(@RequestBody SensorData measurement, @PathVariable("key") String key) {
		DataStream ownerStream = services.findByKey(key);
	
		measurement.setOwnerStream(ownerStream);
		measurement.setMeasurementUnit(ownerStream.getMeasurementUnit());
		
		SensorDataExplicitDTO entityDTO = sensorDataServices.createDTO(measurement);
		
		ownerStream.getMeasurements().add(measurement);
		ownerStream.incrementMeasurementCount();
		services.save(ownerStream);
		
		return entityDTO;
	}
	
	//	TODO: Query personalizada para pegar medições de uma determinada key direto do banco
	@GetMapping("/{key}/measurement")
	public List<SensorData> getAllSensorData(@PathVariable("key") String key) {
		DataStream ownerStream = services.findByKey(key);
		return ownerStream.getMeasurements();
	}
	
	@GetMapping("/{key}/measurement2")
	public List<SensorData> getAllSensorData2(@PathVariable("key") String key) {
		DataStream ownerStream = services.findByKey(key);
		return sensorDataServices.findFirst5OrderById(ownerStream);
	}
	
}
