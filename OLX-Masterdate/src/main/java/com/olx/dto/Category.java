package com.olx.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "CATEGORY DTO")
public class Category {
	
	@ApiModelProperty(value = "Category Id")
	private int category_Id;
	
	@ApiModelProperty(value = "Category Name")
	private String category_Name;

}
