package com.zensar.enttity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name = "STOCKS")
public class StockEntity {
	
	@Id
	@GeneratedValue
	private int id;
	
	
	private String name;
	
	private String market;
	
	
	private int price;
	
	
}
