package com.enzoccs.springbootmongodb.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enzoccs.springbootmongodb.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResources {
	
	@GetMapping
	public ResponseEntity<List<User>>  findAll(){
		User enzo = new User("1", "Enzo Cesar", "enzoconsulo@gmail.com");
		User danila = new User("2", "Danila Consulo", "danila@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(enzo,danila));
		return ResponseEntity.ok().body(list);
	}

}
