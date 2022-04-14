package com.revature.dallas_project1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.dallas_project1.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
	
	public Users getUserByUsernameAndPassword(String username,String password);
	
	public Users getUserByUsername(String username);

}
