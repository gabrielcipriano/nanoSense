package br.com.scottpilgrim.nanosense.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.scottpilgrim.nanosense.data.model.SensorData;
import br.com.scottpilgrim.nanosense.data.vo.SensorDataVO;
import br.com.scottpilgrim.nanosense.services.SensorDataServices;


@RestController
@RequestMapping("/sensor-data")
public class SensorDataController {

	@Autowired
	private SensorDataServices services;
	
	@Autowired
	@Qualifier("mvcConversionService")
	ConversionService conversionService;
	
	@GetMapping
	public List<SensorDataVO> findAll(){
		List<SensorData> source = services.findAll();
		TypeDescriptor sourceType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(SensorData.class));
		TypeDescriptor targetType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(SensorDataVO.class));
		
		@SuppressWarnings("unchecked") // It's a safe downcast
		List<SensorDataVO> vos = (List<SensorDataVO>) conversionService.convert(source, sourceType, targetType);
		return  vos;
	}
	
	@PostMapping
	public SensorDataVO create(@RequestBody SensorDataVO sensorData){
		SensorData entity = conversionService.convert(sensorData, SensorData.class);
		return conversionService.convert(services.create(entity), SensorDataVO.class);
	}
	
	@PutMapping
	public SensorDataVO update(@RequestBody SensorDataVO sensorData){
		SensorData entity = conversionService.convert(sensorData, SensorData.class);
		return conversionService.convert(services.update(entity), SensorDataVO.class);
	}
	
	
	
	@GetMapping("/{id}")
	public SensorDataVO findById(@PathVariable("id") Long id){
		return conversionService.convert(services.findById(id), SensorDataVO.class);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		services.delete(id);
		return ResponseEntity.ok().build();
	}
	
	
}
