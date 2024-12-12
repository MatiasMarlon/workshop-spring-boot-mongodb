package com.udemy.workshomongo.resources.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.udemy.workshomongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}