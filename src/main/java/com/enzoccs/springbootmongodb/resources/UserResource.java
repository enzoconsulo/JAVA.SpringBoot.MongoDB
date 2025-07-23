package com.enzoccs.springbootmongodb.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enzoccs.springbootmongodb.domain.User;
import com.enzoccs.springbootmongodb.dto.UserDTO;
import com.enzoccs.springbootmongodb.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
		
	@Autowired
	private UserService uService;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>>  findAll(){
		List<User> list = uService.findAll();
		List<UserDTO> listDTO= list.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User u = uService.findById(id);
		UserDTO uDTO = new UserDTO(u);
		return ResponseEntity.ok().body(uDTO);
	}

	
}
