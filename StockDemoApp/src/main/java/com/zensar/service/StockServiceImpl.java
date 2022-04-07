package com.zensar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.dto.Stock;
import com.zensar.enttity.StockEntity;
import com.zensar.repository.StockRepo;

@Service
public class StockServiceImpl implements StockService{
	
	@Autowired
	StockRepo stockrepo;

	@Override
	public List<Stock> getAllStocks() {
		return null;
	}

	@Override
	public Stock getStockById(int stockId) {
		stockrepo.getById(stockId);
		return null;
		
	}



	@Override
	public boolean deleteStockById(int stockId) {
		stockrepo.deleteById(stockId);
		return true;
	}

	@Override
	public boolean deleteAllStocks() {
		stockrepo.deleteAllInBatch();
		return true;
	}

	@Override
	public Stock updateStock(int stockId, Stock updatedStock) {
			Optional<StockEntity> opStockEntity  = stockrepo.findById(stockId);
			if(opStockEntity.isPresent()) {
				StockEntity stockEntity = opStockEntity.get();
				stockEntity.setMarket(updatedStock.getMarket());
				stockEntity.setName(updatedStock.getName());
				stockEntity.setPrice(updatedStock.getPrice());
				stockrepo.save(stockEntity);
		}
		return null;
	}

	@Override
	public Stock createNewStock(Stock stock) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private StockEntity convertDTOIntoEntity(Stock stock) {
		return new StockEntity(stock.getId(), stock.getName(), stock.getMarket(), stock.getPrice());
		
	}


}
