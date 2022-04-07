package com.zensar.service;

import java.util.List;

import com.zensar.dto.Stock;

public interface StockService {
	public List<Stock> getAllStocks();
	public Stock getStockById(int stockId);
	public Stock createNewStock(Stock stock);
	public Stock updateStock(int Stock, Stock updatedStock);
	public boolean deleteStockById(int stockId);
	public boolean deleteAllStocks();
	
	

}
