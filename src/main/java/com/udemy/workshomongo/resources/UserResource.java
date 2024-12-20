package com.udemy.workshomongo.resources;

import java.net.URI;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.udemy.workshomongo.domain.Post;
import com.udemy.workshomongo.domain.User;
import com.udemy.workshomongo.dto.UserDTO;
import com.udemy.workshomongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		 // Converte a lista de User para UserDTO
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
		
/*User maria = new User("1001", "Maria Brown", "maria@gmail.com");
User alex = new User("1002", "Alex Green", "alex@gmail.com");
list.addAll(Arrays.asList(maria, alex));
return ResponseEntity.ok().body(list);
 */
		@GetMapping(value = "/{id}")
		public ResponseEntity<UserDTO> findById(@PathVariable String id) {
			User obj = service.findById(id);
			return ResponseEntity.ok().body(new UserDTO(obj));
	}
		
		@PostMapping
		public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
			User obj = service.fromDTO(objDto);
			obj = service.insert(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}
		
		@DeleteMapping(value = "/{id}")
		public ResponseEntity<Void> delete(@PathVariable String id) {
			service.delete(id);
			return ResponseEntity.noContent().build();
		}
		
		@PutMapping(value = "/{id}")
		public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id ) {
			User obj = service.fromDTO(objDto);
			obj.setId(id);
			obj = service.update(obj);
			return ResponseEntity.noContent().build();
		}
			@GetMapping(value = "/{id}/posts")
			public ResponseEntity<List<Post>> findPost(@PathVariable String id) {
				User obj = service.findById(id);
				return ResponseEntity.ok().body(obj.getPosts());
		
		}
		
}