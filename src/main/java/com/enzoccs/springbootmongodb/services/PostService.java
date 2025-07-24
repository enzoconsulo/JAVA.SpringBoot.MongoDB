package com.enzoccs.springbootmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enzoccs.springbootmongodb.domain.Post;
import com.enzoccs.springbootmongodb.repositories.PostRepository;
import com.enzoccs.springbootmongodb.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository pRep;
	
	public List<Post> findAll(){
		return pRep.findAll();
	}
	
	public Post findById(String id) {
		Optional<Post> post = pRep.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("post not Found!"));
							//   |
							//   V
						//empty parameters to Supplier 
	}
	
	public List<Post> findByTitle(String search){
		return pRep.findByTitleContainingIgnoreCase(search);
	}
}
