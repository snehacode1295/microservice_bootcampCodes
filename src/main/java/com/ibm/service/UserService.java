package com.ibm.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.ibm.model.User;


@Service
public interface UserService {
	User findByLoginID(String loginID) throws Exception;
	User getUserDetailById(long userId) throws Exception;
	User signUpUser(HashMap<String,String> signupRequest) throws Exception;
	
}
