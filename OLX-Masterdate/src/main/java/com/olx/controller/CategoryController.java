package com.olx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olx.dto.Category;
import com.olx.dto.Status;
import com.olx.service.CategoryService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/olx/advertise")
@CrossOrigin(origins = "*")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@GetMapping(value = "/category", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ApiOperation(value = "Reads all category", notes = "This REST API returns list of all categories")
	public List<Category> getAllCategory() {
		return categoryService.getAllCategory();
	}

	@ApiOperation(value = "Reads all status", notes = "This REST API returns list of all status")
	@GetMapping(value = "/status", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Status> getAllStatus() {
		return categoryService.getAllStatus();
	}

}
