package br.com.scottpilgrim.nanosense.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.scottpilgrim.nanosense.converter.DozerConverter;
import br.com.scottpilgrim.nanosense.dto.SensorDataExplicitDTO;
import br.com.scottpilgrim.nanosense.exception.BadRequestException;
import br.com.scottpilgrim.nanosense.exception.ResourceNotFoundException;
import br.com.scottpilgrim.nanosense.model.DataStream;
import br.com.scottpilgrim.nanosense.model.SensorData;
import br.com.scottpilgrim.nanosense.repository.SensorDataRepository;

@Service
public class SensorDataServices {
	
	@Autowired
	SensorDataRepository repository;
	
	public SensorDataExplicitDTO createDTO(SensorData sensorData) {
		if (!sensorData.getOwnerStream().isEnabled())
			throw new BadRequestException("This Data Stream is disabled.");
		var dto = DozerConverter.parseObject(repository.save(sensorData), SensorDataExplicitDTO.class);
		return dto;
	}
	
	public List<SensorData> findAll(){
		return repository.findAll();
	}
	
	public SensorData findById(Long id ) {
		return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
	}
	
	public void delete(Long id) {
		SensorData entity = repository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}
	
	public List<SensorData> findFirst5OrderById(DataStream ownerStream){
		return repository.findFirst5ByOwnerStreamOrderByIdDesc(ownerStream);
		
	}
	
}
