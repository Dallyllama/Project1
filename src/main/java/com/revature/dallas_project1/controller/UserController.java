package com.revature.dallas_project1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dallas_project1.model.Users;
import com.revature.dallas_project1.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public List<Users> getUsers() {
		return userService.findAll();
	}
	
	@GetMapping("/users/{username}")
	public Users getUserByUsername(@PathVariable String username) {
		return userService.viewUser(username);
	}
	
	@PutMapping("/users")
	public Users updateUser(@RequestBody Users U) {
		return userService.updateUser(U.getId(),U);
	}
}
