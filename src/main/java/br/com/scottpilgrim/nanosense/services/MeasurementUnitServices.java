package br.com.scottpilgrim.nanosense.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.scottpilgrim.nanosense.exception.ResourceNotFoundException;
import br.com.scottpilgrim.nanosense.model.MeasurementUnit;
import br.com.scottpilgrim.nanosense.repository.MeasurementUnitRepository;

@Service
public class MeasurementUnitServices {
	
	@Autowired
	MeasurementUnitRepository repository;
	
	public MeasurementUnit create(MeasurementUnit measurementUnit) {
		return repository.save(measurementUnit);
	}
	
	public List<MeasurementUnit> findAll(){
		return repository.findAll();
	}
	
	public MeasurementUnit findById(Long id ) {

		return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
	}
	
	public MeasurementUnit update(MeasurementUnit measurementUnit) {
		MeasurementUnit entity = repository.findById(measurementUnit.getId())
				.orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));

		entity.setSymbol(measurementUnit.getSymbol());
		entity.setDescription(measurementUnit.getDescription());
		
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		MeasurementUnit entity = repository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}
}
