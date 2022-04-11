package com.olx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olx.dto.User;
import com.olx.service.LoginService;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/olx/login")
@CrossOrigin(origins = "*")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping(value = "/user/authenticate", consumes={ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(value = "Authenticate User", notes = "This REST API return autheticate message ")
	public String authenticate(@RequestBody User user) {
		return loginService.authenticate(user);
	}
	
	@DeleteMapping(value = "/user/logout")
	@ApiOperation(value = "Logout", notes = "This REST API is used to logout from the application")
	public boolean logout(@RequestHeader("auth-token") String authToken ) {
		return loginService.logout(authToken);
	}
	
	@PostMapping(value = "/user", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Registeration of User", notes = "This REST API is used to register new user")
	public User registerUser(@RequestBody User user) {
		return loginService.registerUser(user);
		
	}
	
//	@GetMapping(value = "/user")
//	public User getUser(@RequestHeader("auth-token") String authToken) {
//		return loginService.getUser(authToken);
//	}
	
	@GetMapping(value = "/user", produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(value = "Get Users", notes = "This REST API returns all Users")
	public User getUser(User user) {
	return loginService.getUser(user);
	}
	
	@GetMapping(value = "/token/validate")
	@ApiOperation(value = "Token Validation", notes = "This REST API is used to token validation.")
	public boolean tokenValidate(@RequestHeader("auth-token") String authToken) {
		return loginService.tokenValidate(authToken);
		
	}

}
