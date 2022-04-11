package com.olx.service;

import java.util.List;

import com.olx.dto.User;

public interface LoginService {
	
	public String authenticate(User user);
	
	public boolean logout(String authToken);
	
	public User registerUser(User user);
	
//	public User getUser(String authToken);
	
	public boolean tokenValidate(String authToken);

	public User getUser(User user);
	
	public List getAllUsers();



}
