package com.olx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olx.dto.Category;
import com.olx.service.CategoryService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/olx/advertise")
@CrossOrigin(origins = "*")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping(value = "/advertise/category", produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(value = "Reads all Categories", notes = "This REST API returns all categories")
	public List category() {
		return categoryService.category();
		
	}
	
	
	@GetMapping(value = "//advertise/status", produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(value = "Reads all Status", notes = "This REST API return all Status")
	public List categoryStatus() {
		return categoryService.categoryStatus();
		
	}
	
	

}
