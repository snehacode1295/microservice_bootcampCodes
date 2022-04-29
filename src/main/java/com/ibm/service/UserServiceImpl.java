package com.ibm.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.model.User;
import com.ibm.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public User findByLoginID(String loginID) throws Exception {
		return userRepo.findByLoginID(loginID).orElseThrow(()->new Exception("User Not found.."));
	}

	@Override
	public User getUserDetailById(long userId) throws Exception {
		
		return userRepo.findById(userId).orElseThrow(()->new Exception("User Not found.."));
	}

	@Override
	public User signUpUser(HashMap<String, String> signupRequest) throws Exception {
		try {
			if(userRepo.findByLoginID(signupRequest.get("loginID")).isPresent()) {
				throw new Exception("User is already present.");
			}
			User user = new User();
			user.setName(signupRequest.get("name"));
			user.setEmail(signupRequest.get("email"));
			user.setLoginID(signupRequest.get("loginID"));
			user.setPassword(signupRequest.get("password"));
			userRepo.save(user);
			return user;
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
}
