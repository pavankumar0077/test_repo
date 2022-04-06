package com.zensar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/stockapp")
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "*")
public class StockController {

	static List<Stock> stocks = new ArrayList<Stock>();
	static {
		stocks.add(new Stock(1, "Zensar","BSE",50));
		stocks.add(new Stock(2, "IBM","NSE",20));
		stocks.add(new Stock(3, "AMAZON","NSE",80));
	}
	
	@GetMapping(value = "/stock", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Reads all Stocks", notes = "This REST API return list of all stocks")
	public List<Stock> getAllStocks() {
		return stocks;
	}
	
	@GetMapping(value = "/stock/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Reads Stocks by Id", notes = "This REST API returns stock by Id")
	public Stock getStockById(@ApiParam(value = "Stock id", name = "id") @PathVariable("id") int stockId) {
		for(Stock stock : stocks) {
			if(stock.getId()==stockId) {
				return stock;
			}
		}
		return null;
	}
	
	@PostMapping(value = "/stock", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(value = "Creates New Stock", notes = "This REST API creates new stock")
	public Stock createNewStock(@RequestBody Stock stock) {
		stock.setId(stocks.size() + 1);
		stocks.add(stock);
		return stock;
		
	}
	
	@PutMapping(value = "/stock/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Update Stock", notes = "This REST API update's the stock")
	public Stock updateStock(@PathVariable("id") int stockId,@RequestBody Stock updatedStock) {
		Stock existingStock = getStockById(stockId);
		existingStock.setName(updatedStock.getName());
		existingStock.setMarket(updatedStock.getMarket());
		existingStock.setPrice(updatedStock.getPrice());
		return updatedStock;
		
	}
	
	@DeleteMapping(value = "/stock/{id}")
	@ApiOperation(value = "Delete Stock", notes = "This REST API delete's the stock")
	public boolean deleteStockById(@PathVariable("id") int stockId) {
		for(Stock stock : stocks) {
			if(stock.getId()==stockId) {
				stocks.remove(stock);
				return true;
			}
		}
		return false;
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
	public boolean deleteAllStocks( ) {
		stocks.clear();
		return true;
	}
	
	@GetMapping(value = "/employee")
	public boolean testRequestParam(@RequestParam(value = "eid", required = false) int empId) {
		System.out.println("Emp id : " + empId);
		return true;
	}
	
	@GetMapping(value = "/employee2")
	public boolean testHeaderParam(@RequestHeader(value = "auth-token") String authToken) {
		System.out.println("Auth Token : " +authToken);
		return true;
	}
	
//	@GetMapping(value = "/employee3")
//	public boolean testQueryrParam(@QueryParam(value = "name") String name) {
//		System.out.println("Name : " +name);
//		return true;
//	}
	
	
	
	
}
