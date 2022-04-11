package com.olx.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OLX-ADVERTISES")
public class AdvertiseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String title;
	private String description;
	private double price;
	private long category;
	@Column(name = "created_date")
	private LocalDate createdDate;
	@Column(name = "modified_date")
	private LocalDate modifiedDate;
	private String active;
	@Column(name = "username")
	private String username;
}
