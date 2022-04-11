package com.olx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OLXUSERS")
public class UserEntity {
	
	@Id
	@GeneratedValue
	private int id;

	private String firstName;
	
//	@Id
//	@Column(name = "UserName", nullable = false) 
//	@Column(columnDefinition = "text")
	private String userName;

	private String lastName;

	private String password;

	private String email;

	private double phone;

}
