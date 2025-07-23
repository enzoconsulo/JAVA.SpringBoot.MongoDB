package com.enzoccs.springbootmongodb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enzoccs.springbootmongodb.domain.User;
import com.enzoccs.springbootmongodb.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
		
	@Autowired
	private UserService uService;
	
	@GetMapping
	public ResponseEntity<List<User>>  findAll(){
		List<User> list = uService.findAll();
		return ResponseEntity.ok().body(list);
	}

	
}
