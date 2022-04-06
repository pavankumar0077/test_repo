package com.olx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "OLX LOGIN DTO")
public class User {
	@ApiModelProperty(value = "FirstName")
	private String firstName;
	
	@ApiModelProperty(value = "UserName")
	private String userName;
	
	@ApiModelProperty(value = "LastName")
	private String lastName;
	
	@ApiModelProperty(value = "Password")
	private String password;
	
	@ApiModelProperty(value = "Email")
	private String email;
	
	@ApiModelProperty(value = "Phone Number")
	private double phone;

}
