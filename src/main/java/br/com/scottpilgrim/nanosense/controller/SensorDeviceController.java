package br.com.scottpilgrim.nanosense.controller;


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
import br.com.scottpilgrim.nanosense.model.DataStream;
import br.com.scottpilgrim.nanosense.model.MeasurementUnit;
import br.com.scottpilgrim.nanosense.model.SensorDevice;
import br.com.scottpilgrim.nanosense.services.DataStreamServices;
import br.com.scottpilgrim.nanosense.services.MeasurementUnitServices;
import br.com.scottpilgrim.nanosense.services.SensorDeviceServices;


@RestController
@RequestMapping("/device")
public class SensorDeviceController {

	@Autowired
	private SensorDeviceServices services;
	
	@Autowired
	private DataStreamServices streamServices;
	
	@Autowired
	private MeasurementUnitServices unitServices;
	
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
	
	@PostMapping("/{key}/stream")
	public DataStream createStream(@RequestBody DataStream stream, @PathVariable("key") String deviceKey) {
		SensorDevice ownerDevice = findByKey(deviceKey);
		MeasurementUnit unit = unitServices.findById(stream.getUnitId());
		
		stream.setMeasurementUnit(unit);
		stream.setOwnerDevice(ownerDevice);
		
		// Getting from DTO
//		DataStream dataStream = new DataStream();
//		dataStream.setEnabled(stream.isEnabled());
//		dataStream.setLabel(stream.getLabel());
//		dataStream.setMeasurementUnit(unit);
//		dataStream.setOwnerDevice(ownerDevice);
		
		DataStream streamEntity = streamServices.create(stream);
		
		ownerDevice.getStreams().add(streamEntity);
		
		services.update(ownerDevice);
		
		// Updating DTO
//		stream.setKey(streamEntity.getKey());
//		stream.setId(streamEntity.getId());
//		stream.setMeasurementCount(streamEntity.getMeasurementCount());
//		stream.setDeviceId(ownerDevice.getId());
//		stream.setUnitId(streamEntity.getMeasurementUnit().getId());
		
		return stream;
	}
	
	
}
