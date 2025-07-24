package com.enzoccs.springbootmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.enzoccs.springbootmongodb.domain.Post;
import java.util.List;


@Repository
public interface PostRepository extends MongoRepository<Post, String>{

	@Query("{"
			+ "'title': {"						//field name
			+ 			" $regex: ?0 ,"         //value set on param (?0 on this case is the first param under, in this case is 'String title')
			+ 			" $options: 'i' "		//option i to insensitivy to cases(lower/upper)
			+ "			} "
			+ "}")
	List<Post> seachTitle(String title);
	
	List<Post> findByTitleContainingIgnoreCase(String title);
}
