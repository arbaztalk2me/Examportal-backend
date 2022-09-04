package com.arbaz.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arbaz.demo.entity.User;

public interface UserRepo extends JpaRepository<User,Long> {
	
	User findByUsername(String username);

}
