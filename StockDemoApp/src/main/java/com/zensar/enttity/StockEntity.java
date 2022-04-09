package com.zensar.enttity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "STOCKS")
public class StockEntity {
	
	@Id
	@GeneratedValue
	private int id;
	
	
	private String name;
	
	@Column(name = "market")
	private String marketname;
	
	@Column(name = "price")
	private int price;
	
	
}
