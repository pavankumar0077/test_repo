package com.olx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ADVERTISE DTO")
public class Advertise {

	@ApiModelProperty(value = "Advertisement Title")
	private String title;
	
	@ApiModelProperty(value = "Advertisement Price")
	private int price;
	
	@ApiModelProperty(value = "Advertisement Category ID")
	private int catId;
	
	@ApiModelProperty(value = "Advertisement Description")
	private String desc;

}
