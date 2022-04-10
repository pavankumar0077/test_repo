package com.olx.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.olx.dto.User;

public interface LoginService {
	
	public String authenticate(@RequestBody User user);
	
	public boolean logout(String authToken);
	
	public User registerUser(User user);
	
//	public User getUser(String authToken);
	
	public boolean tokenValidate(String authToken);

	public User getUser(User user);



}
