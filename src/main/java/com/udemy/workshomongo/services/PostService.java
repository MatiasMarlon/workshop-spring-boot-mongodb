package com.udemy.workshomongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.udemy.workshomongo.domain.Post;
import com.udemy.workshomongo.repository.PostRepository;
import com.udemy.workshomongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
		public Post findById(String id) {
			Optional<Post> obj = repo.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
}
