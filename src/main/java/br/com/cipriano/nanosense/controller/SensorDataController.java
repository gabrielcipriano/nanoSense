//package br.com.cipriano.nanosense.controller;
//
//
////import java.time.LocalDateTime;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.com.cipriano.nanosense.model.User;
//import br.com.cipriano.nanosense.services.UserServices;
//
//
//@RestController
//@RequestMapping("/sersor-data")
//public class SensorDataController {
////	@GetMapping
////	public LocalDateTime findAll(){
////		return LocalDateTime.ofEpochSecond(1506455591, 0, null);
////	}
////	
//	
//
//	@Autowired
//	private UserServices services;
//	
//	@GetMapping
//	public List<User> findAll(){
//		return services.findAll();
//	}
//	
//	@PostMapping
//	public User create(@RequestBody User user){
//		return services.create(user);
//	}
//	
//	@PutMapping
//	public User update(@RequestBody User user){
//		return services.update(user);
//	}
//	
//	@GetMapping("/{id}")
//	public User findById(@PathVariable("id") Long id){
//		return services.findById(id);
//	}
//
//	@DeleteMapping("/{id}")
//	public ResponseEntity<?> delete(@PathVariable("id") Long id){
//		services.delete(id);
//		return ResponseEntity.ok().build();
//	}
//	
//	
//}
