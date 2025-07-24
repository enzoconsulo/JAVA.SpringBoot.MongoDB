package com.enzoccs.springbootmongodb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enzoccs.springbootmongodb.domain.Post;
import com.enzoccs.springbootmongodb.resources.util.URL;
import com.enzoccs.springbootmongodb.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
		
	@Autowired
	private PostService pService;
	
	@GetMapping
	public ResponseEntity<List<Post>>  findAll(){
		List<Post> list = pService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post u = pService.findById(id);
		return ResponseEntity.ok().body(u);
	}
	
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text",defaultValue = "") String search){
		search = URL.decodeFromUrl(search);
		List<Post> list = pService.findByTitle(search);
		return ResponseEntity.ok().body(list);
	}

}
