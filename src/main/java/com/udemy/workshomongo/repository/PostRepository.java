package com.udemy.workshomongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.udemy.workshomongo.domain.Post;
import com.udemy.workshomongo.domain.User;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
