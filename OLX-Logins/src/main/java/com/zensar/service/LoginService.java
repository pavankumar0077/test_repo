package com.zensar.service;


import java.util.List;

import com.zensar.dto.User;

public interface LoginService {
	public String authenticate(User user);

	public boolean logout(String authToken);

	public User registerUser(User user);

	public User getUser(int id);

	public String validateToken(String authToken);

//	User getUser();

}