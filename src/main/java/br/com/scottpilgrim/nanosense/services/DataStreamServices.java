package br.com.scottpilgrim.nanosense.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.scottpilgrim.nanosense.converter.DozerConverter;
import br.com.scottpilgrim.nanosense.dto.DataStreamExplicitDTO;
import br.com.scottpilgrim.nanosense.exception.ResourceNotFoundException;
import br.com.scottpilgrim.nanosense.model.DataStream;
import br.com.scottpilgrim.nanosense.repository.DataStreamRepository;

@Service
public class DataStreamServices {
	
	@Autowired
	DataStreamRepository repository;
	
	public DataStream create(DataStream dataStream) {
		return repository.save(dataStream);
	}
	
	public List<DataStream> findAll(){
		return repository.findAll();
	}
	
	
	
	public DataStream findById(Long id ) {

		return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
	}
	
	public DataStreamExplicitDTO findDTOByKey(String key) {
		DataStream entity = repository.findByKey(key).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
		var vo = DozerConverter.parseObject(entity, DataStreamExplicitDTO.class);
		return vo;
	}
	
	public DataStream findByKey(String key) {
		return repository.findByKey(key)
				.orElseThrow(()-> new ResourceNotFoundException("No records found for this Key"));
	}
	
	public DataStream update(DataStream dataStream) {
		DataStream entity = repository.findByKey(dataStream.getKey())
				.orElseThrow(()-> new ResourceNotFoundException("No records found for this Key"));

		entity.setEnabled(dataStream.isEnabled());
		entity.setLabel(dataStream.getLabel());
		
		return repository.save(entity);
	}
	
	public DataStream save(DataStream dataStream) {
		return repository.save(dataStream);
	}
	
	public void delete(String key) {
		DataStream entity = repository.findByKey(key)
				.orElseThrow(()-> new ResourceNotFoundException("No records found for this Key"));
		repository.delete(entity);
	}
	

}
