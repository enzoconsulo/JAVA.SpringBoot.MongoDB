package com.enzoccs.springbootmongodb.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.enzoccs.springbootmongodb.domain.Post;


@Repository
public interface PostRepository extends MongoRepository<Post, String>{

	@Query(   "{"
			+ "'title': {"						//field name on db
			+ 			" $regex: ?0 ,"         //value set on param (?0 on this case is the first param under, in this case is 'String search')
			+ 			" $options: 'i' "		//option i to insensitivy to cases(lower/upper)
			+ "			} "
			+ "}")
	List<Post> seachTitle(String search);
	
	
	@Query("{"
		    + "  $and: ["
		    + "    { 'date': { $gte: ?1 } },"
		    + "    { 'date': { $lte: ?2 } },"		// Search for posts containing a given string anywhere (in the title, body, or comments) and within a given date range
		    + "    {"
		    + "      $or: ["
		    + "        { 'title': { $regex: ?0, $options: 'i' } },"
		    + "        { 'body': { $regex: ?0, $options: 'i' } }," 
		    + "        { 'comments.text': { $regex: ?0, $options: 'i' } }"
		    + "      ]"
		    + "    }"
		    + "  ]"
		    + "}")
	List<Post> fullSearch(String search,Date minDate,Date maxDate);
	
	List<Post> findByTitleContainingIgnoreCase(String title);
}
