package com.enzoccs.springbootmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enzoccs.springbootmongodb.domain.User;
import com.enzoccs.springbootmongodb.dto.NewUserDTO;
import com.enzoccs.springbootmongodb.repositories.UserRepository;
import com.enzoccs.springbootmongodb.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository uRep;
	
	public List<User> findAll(){
		return uRep.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = uRep.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("User not Found!"));
							//   |
							//   V
						//empty parameters to Supplier 
	}
	
	public User insert(User user) {
		return uRep.insert(user);
	}
	
	public User fromDTO(NewUserDTO userDTO) {
		return new User(userDTO.getId(),userDTO.getName(),userDTO.getEmail(),userDTO.getPassword());
	}
	
}
