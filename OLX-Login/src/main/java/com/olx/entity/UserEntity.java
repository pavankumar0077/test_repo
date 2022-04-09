package com.olx.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "OLX-USERS")
public class UserEntity {

	private String firstName;

	private String userName;

	private String lastName;

	private String password;

	private String email;

	private double phone;

}
