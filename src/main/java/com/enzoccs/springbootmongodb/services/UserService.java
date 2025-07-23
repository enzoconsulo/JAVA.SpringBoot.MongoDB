package com.enzoccs.springbootmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enzoccs.springbootmongodb.domain.User;
import com.enzoccs.springbootmongodb.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository uRep;
	
	public List<User> findAll(){
		return uRep.findAll();
	}
}
