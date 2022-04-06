package com.olx.service;

import org.springframework.stereotype.Service;

import com.olx.dto.User;

@Service
public class LoginServiceImpl implements LoginService {

	@Override
	public String authenticate(User user) {
		return "A78DT";
	}

	@Override
	public boolean logout(String authToken) {
		return true;
	}

	@Override
	public User registerUser(User user) {
		return user;
	}

	@Override
	public boolean tokenValidate(String authToken) {
		return true;
	}

	@Override
	public User getUser(User user) {
		return user;
	}

//	@Override
//	public User getUser(String authToken) {
//		return registerUser(null);
//	}

}
