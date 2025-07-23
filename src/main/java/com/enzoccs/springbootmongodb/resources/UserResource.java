package com.enzoccs.springbootmongodb.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.enzoccs.springbootmongodb.domain.User;
import com.enzoccs.springbootmongodb.dto.NewUserDTO;
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
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody NewUserDTO userDTO){
		User temp = uService.fromDTO(userDTO);
		temp = uService.insert(temp);
		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(temp.getId())
					.toUri();
		return ResponseEntity.created(uri).build();		
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		uService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody NewUserDTO user){	
		User u = uService.fromDTO(user);
		u.setId(id);
		uService.update(u);
		return ResponseEntity.noContent().build();
	}
	
}
