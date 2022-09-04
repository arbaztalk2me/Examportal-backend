package com.arbaz.demo.services;

import com.arbaz.demo.entity.User;

public interface UserService {
	
	User createUser(User user) throws Exception;
	
	User getUser(String username);
	
	void deleteUser(Long id);

}
