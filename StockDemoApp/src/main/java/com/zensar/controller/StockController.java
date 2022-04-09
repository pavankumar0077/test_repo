package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.dto.Stock;
import com.zensar.service.StockService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/stockapp")
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "*")
public class StockController {

	@Autowired
	StockService stockService;

	@GetMapping(value = "/stock", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Reads all Stocks", notes = "This REST API return list of all stocks")
	public List<Stock> getAllStocks() {
		return stockService.getAllStocks();
	}

	@GetMapping(value = "/stock/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Reads Stocks by Id", notes = "This REST API returns stock by Id")
	public Stock getStockById(@ApiParam(value = "Stock id", name = "id") @PathVariable("id") int stockId) {
		return stockService.getStockById(stockId);
	}

	@PostMapping(value = "/stock", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Creates New Stock", notes = "This REST API creates new stock")
	public Stock createNewStock(@RequestBody Stock stock) {
		return stockService.createNewStock(stock);

	}

//	@PutMapping(value = "/stock/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	@ApiOperation(value = "Update Stock", notes = "This REST API update's the stock")
//	public Stock updateStock(@PathVariable("id") int stockId,@RequestBody Stock updatedStock) {
//		return stockService.updateStock(updatedStock);
//		
//	}

	@PutMapping(value = "/stock/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	@ApiOperation(value = "ediitng a stockc", notes = "edit a stock")

	public Stock updateStock(@PathVariable("id") int stockId, @RequestBody Stock updatedStock) {
		return stockService.updateStock(stockId, updatedStock);
	}

	@DeleteMapping(value = "/stock/{id}")
	@ApiOperation(value = "Delete Stock", notes = "This REST API delete's the stock")
	public boolean deleteStockById(@PathVariable("id") int stockId) {
		return stockService.deleteStockById(stockId);
	}

//	@DeleteMapping(value = "/stock/delete")
//	public String deleteAllStocks() {
//		for(Stock stock : stocks) { 
//				stocks.removeAll(stocks);
//				return "Deleted";
//			}
//		return "Not Deleted";
//		
//	}

	@DeleteMapping(value = "/stock")
	@ApiOperation(value = "Delete All Stocks", notes = "This REST API returns empty list")
	public boolean deleteAllStocks() {
		return stockService.deleteAllStocks();
	}

	@GetMapping(value = "/employee")
	public boolean testRequestParam(@RequestParam(value = "eid", required = false) int empId) {
		System.out.println("Emp id : " + empId);
		return true;
	}

	@GetMapping(value = "/employee2")
	public boolean testHeaderParam(@RequestHeader(value = "auth-token") String authToken) {
		System.out.println("Auth Token : " + authToken);
		return true;
	}

//	@GetMapping(value = "/employee3")
//	public boolean testQueryrParam(@QueryParam(value = "name") String name) {
//		System.out.println("Name : " +name);
//		return true;
//	}
	
	
	@GetMapping(value="/stock/name/{name}", produces= { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Stock>> getStocksByName(@PathVariable("name") String stockName) {
	return new ResponseEntity<List<Stock>>(stockService.getStocksByName(stockName), HttpStatus.OK);
	}



	@GetMapping(value="/stock/sort/{sortType}", produces= { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Stock>> getStocksSortedByName(@PathVariable("sortType") String sortType) {
	return new ResponseEntity<List<Stock>>(stockService.getStocksSortedByName(sortType), HttpStatus.OK);
	}



	@GetMapping(value="/stock/{startIndex}/{records}", produces= { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Stock>> getStocksByPage(@PathVariable("startIndex") int startIndex,
	@PathVariable("records") int records) {
	return new ResponseEntity<List<Stock>>(stockService.getStocksByPage(startIndex, records), HttpStatus.OK);
	}



	@GetMapping(value="/stock/like/{namelike}", produces= { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Stock>> getStocksByNameLike(@PathVariable("namelike") String namelike) {
	return new ResponseEntity<List<Stock>>(stockService.getStocksByNameLike(namelike), HttpStatus.OK);
	}



}
