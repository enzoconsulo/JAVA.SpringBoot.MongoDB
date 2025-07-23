package com.enzoccs.springbootmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.enzoccs.springbootmongodb.domain.User;
import com.enzoccs.springbootmongodb.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com","1234");
		User alex = new User(null, "Alex Green", "alex@gmail.com","12345");
		User bob = new User(null, "Bob Grey", "bob@gmail.com","4321");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
	}

}
