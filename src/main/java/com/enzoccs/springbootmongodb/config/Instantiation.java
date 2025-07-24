package com.enzoccs.springbootmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.enzoccs.springbootmongodb.domain.Post;
import com.enzoccs.springbootmongodb.domain.User;
import com.enzoccs.springbootmongodb.dto.AuthorDTO;
import com.enzoccs.springbootmongodb.dto.CommentDTO;
import com.enzoccs.springbootmongodb.dto.UserDTO;
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
		
		userRepository.saveAll(Arrays.asList(maria, alex, enzo));
		
		Post post1 = new Post(null, sdf.parse("21/07/2025"), "Making a springboot project!", "Image", new AuthorDTO(enzo));	
		Post post2 = new Post(null, sdf.parse("23/07/2025"), "Finishing the project !", "Image2", new AuthorDTO(enzo));
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		enzo.getPosts().add(post1);
		enzo.getPosts().add(post2);
		userRepository.save(enzo);
		
		CommentDTO comment1 = new CommentDTO("GoodLuck on your journey", sdf.parse("21/07/2025"), new UserDTO(alex));
		CommentDTO comment2 = new CommentDTO("Nice! Show us the results!", sdf.parse("21/07/2025"), new UserDTO(maria));
		CommentDTO comment3 = new CommentDTO("Wow! Thats rlly good", sdf.parse("23/07/2025"), new UserDTO(maria));
		
		post1.getComments().add(comment1);
		post1.getComments().add(comment2);
		post2.getComments().add(comment3);
		
		postRepository.saveAll(Arrays.asList(post1,post2));
	}

}
