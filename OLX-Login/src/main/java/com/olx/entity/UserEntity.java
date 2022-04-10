package com.olx.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "OLX-USERS")
public class UserEntity {

	private String firstName;

	private String userName;

	private String lastName;

	private String password;

	private String email;

	private double phone;

}
