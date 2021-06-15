package br.com.cipriano.nanosense.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cipriano.nanosense.exception.ResourceNotFoundException;
import br.com.cipriano.nanosense.model.User;
import br.com.cipriano.nanosense.repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	UserRepository repository;
	
	public User create(User user) {
		return repository.save(user);
	}
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id ) {

		return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
	}
	
	public User update(User user) {
		User entity = repository.findById(user.getId())
				.orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));

		entity.setUsername(user.getUsername());
		entity.setEmail(user.getEmail());
		
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		User entity = repository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}
}
