package com.revature.web;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.User;
import com.revature.service.UserService;

@RestController
@RequestMapping("/users") // all functionality is available at http://localhost:5000/api/users...
public class UserController {

	@Autowired // inject the service dependency into our controller class
	private UserService userServ; 
	
	// when a client sends a GET request to http://localhost:5000/api/users, they retrieve all users
	@GetMapping
	public ResponseEntity<Set<User>> getAll() {
		
		// Returning a ResponseEntity object alllows you to edit parts of the HTTP response like the status
		return ResponseEntity.ok(userServ.findAll());
		
	}
	
	// to add a User, accept a POST request, and return the added User object
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@Valid @RequestBody User u) { // @Valid ensures that the user object accepted
																	  // abides by the Validations we set up on its properties
		
		return ResponseEntity.ok(userServ.add(u));
		// what happens if a user tries to add a malformed JSON object????
		// we will use power of AOP to intercept the response that's sent back so the user/client
		// knows how to fix it.
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
