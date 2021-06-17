package br.com.scottpilgrim.nanosense.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.scottpilgrim.nanosense.exception.ResourceNotFoundException;
import br.com.scottpilgrim.nanosense.model.SensorData;
import br.com.scottpilgrim.nanosense.repository.SensorDataRepository;

@Service
public class SensorDataServices {
	
	@Autowired
	SensorDataRepository repository;
	
	public SensorData create(SensorData sensorData) {
		return repository.save(sensorData);
	}
	
	public List<SensorData> findAll(){
		return repository.findAll();
	}
	
	public SensorData findById(Long id ) {

		return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
	}
	
	public SensorData update(SensorData sensorData) {
		SensorData entity = repository.findById(sensorData.getId())
				.orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));

		entity.setTimestamp(sensorData.getTimestamp());
		entity.setValue(sensorData.getValue());
		
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		SensorData entity = repository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}
}
