package com.zensar.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@ApiModel(value = "Stock DTO")
public class Stock {
	@ApiModelProperty(value = "Stock identifier")
	private int id;
	
	@ApiModelProperty(value = "Stock name")
	private String name;
	
	@ApiModelProperty(value = "Stock market")
	private String market;
	
	@ApiModelProperty(value = "Stock price")
	private int price;

	
}
