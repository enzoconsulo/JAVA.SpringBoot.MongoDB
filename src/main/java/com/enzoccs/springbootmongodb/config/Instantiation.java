package com.enzoccs.springbootmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.enzoccs.springbootmongodb.domain.Post;
import com.enzoccs.springbootmongodb.domain.User;
import com.enzoccs.springbootmongodb.repositories.PostRepository;
import com.enzoccs.springbootmongodb.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com","1234");
		User alex = new User(null, "Alex Green", "alex@gmail.com","12345");
		User enzo = new User(null, "Enzo c", "enzo@gmail.com","4321");
		
		Post post1 = new Post(null, sdf.parse("21/07/2025"), "Making a springboot project!", "Image", enzo);	
		Post post2 = new Post(null, sdf.parse("23/07/2025"), "Finishing the project !", "Image2", enzo);
		
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		userRepository.saveAll(Arrays.asList(maria, alex, enzo));
	}

}
