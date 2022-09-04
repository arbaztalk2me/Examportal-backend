package com.arbaz.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arbaz.demo.entity.User;
import com.arbaz.demo.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEnocder;
	
	@PostMapping("/")
	public ResponseEntity<User> createUser(@RequestBody User u) throws Exception{
		u.setEnabled(true);
		u.setRole("ROLE_NORMAL");
		u.setPassword(bCryptPasswordEnocder.encode(u.getPassword()));
		User user=this.userService.createUser(u);
		return new ResponseEntity<>(user,HttpStatus.CREATED);
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<User> getUser(@PathVariable("username") String username){
		User user=this.userService.getUser(username);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id){
		this.userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	//update api

}
