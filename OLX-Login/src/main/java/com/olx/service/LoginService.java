package com.olx.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.olx.dto.User;

public interface LoginService {
	
	public String authenticate(@RequestBody User user);
	
	public boolean logout(String authToken);
	
	public User registerUser(@RequestBody User user);
	
//	public User getUser(String authToken);
	
	public boolean tokenValidate(String authToken);

	public User getUser(User user);



}
