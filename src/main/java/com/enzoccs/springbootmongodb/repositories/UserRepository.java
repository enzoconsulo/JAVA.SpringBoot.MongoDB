package com.enzoccs.springbootmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.enzoccs.springbootmongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
