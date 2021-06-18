package br.com.scottpilgrim.nanosense.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.scottpilgrim.nanosense.converter.DozerConverter;
import br.com.scottpilgrim.nanosense.dto.SensorDeviceDTO;
import br.com.scottpilgrim.nanosense.exception.ResourceNotFoundException;
import br.com.scottpilgrim.nanosense.model.DataStream;
import br.com.scottpilgrim.nanosense.model.SensorDevice;
import br.com.scottpilgrim.nanosense.repository.SensorDeviceRepository;

@Service
public class SensorDeviceServices {
	
	@Autowired
	SensorDeviceRepository repository;
	
	@Autowired
	SensorDataServices sensorDataServices;
	
	public SensorDevice create(SensorDevice sensorDevice) {
		return repository.save(sensorDevice);
	}
	
	public List<SensorDevice> findAll(){
		return repository.findAll();
	}
	
	public SensorDevice findById(Long id ) {

		return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
	}
	
	public SensorDeviceDTO findByKeyDTO(String key) {
		SensorDevice sensorDevice = repository.findByKey(key).orElseThrow(()-> new ResourceNotFoundException("No records found for this Key"));
		var deviceDTO = DozerConverter.parseObject(sensorDevice, SensorDeviceDTO.class);
		deviceDTO.getStreams().forEach(
				stream -> stream.setMeasurements(sensorDataServices.findFirst5OrderById(
						DozerConverter.parseObject(stream, DataStream.class
					)))
			);
		return deviceDTO;
	}
	
	public SensorDevice findByKey(String key) {
		return repository.findByKey(key).orElseThrow(()-> new ResourceNotFoundException("No records found for this Key"));
	}
	
	public SensorDevice update(SensorDevice sensorDevice) {
		SensorDevice entity = repository.findByKey(sensorDevice.getKey())
				.orElseThrow(()-> new ResourceNotFoundException("No records found for this Key"));

		entity.setDescription(sensorDevice.getDescription());
		entity.setLabel(sensorDevice.getLabel());
		
		return repository.save(entity);
	}
	
	public void delete(String key) {
		SensorDevice entity = repository.findByKey(key)
				.orElseThrow(()-> new ResourceNotFoundException("No records found for this Key"));
		repository.delete(entity);
	}
	
	
}
