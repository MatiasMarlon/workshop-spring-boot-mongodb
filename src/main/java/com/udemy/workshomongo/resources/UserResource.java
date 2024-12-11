package com.udemy.workshomongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.workshomongo.domain.User;
import com.udemy.workshomongo.resources.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
		/*
		 		User maria = new User("1001", "Maria Brown", "maria@gmail.com");
		User alex = new User("1002", "Alex Green", "alex@gmail.com");
				list.addAll(Arrays.asList(maria, alex));
		return ResponseEntity.ok().body(list);
		 */

		

	}
}