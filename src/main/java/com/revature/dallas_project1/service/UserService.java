package com.revature.dallas_project1.service;

import java.util.List;

import com.revature.dallas_project1.model.Users;

public interface UserService {
	
	public Users userLogin(String username, String password);
	public Users userLogout();
	
	public Users viewUser (String username);
	public Users updateUser(int id, Users users);
	
	public List<Users> findAll();

}