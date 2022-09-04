package com.arbaz.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arbaz.demo.entity.User;
import com.arbaz.demo.repo.UserRepo;
import com.arbaz.demo.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepo userRepo;

	@Override
	public User createUser(User user) throws Exception {
		User local=this.userRepo.findByUsername(user.getUsername());
		if(local!=null) {
			System.out.println("Already Exist");
			throw new Exception("User already present");
		}else {
			local=this.userRepo.save(user);
			return local;
		}
		
		
	}

	@Override
	public User getUser(String username) {
		
		return this.userRepo.findByUsername(username);
	}

	@Override
	public void deleteUser(Long id) {
		this.userRepo.deleteById(id);
		
	}

}
