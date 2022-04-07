package com.zensar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.dto.Stock;
import com.zensar.enttity.StockEntity;
import com.zensar.repository.StockRepo;

@Service
public class StockServiceImpl implements StockService {

	private static final Integer stockId = null;
	private static final Stock stockEntity = null;
	private static final Stock stock = null;
//	private static final com.zensar.dto.Stock Stock = null;
//	private static final com.zensar.dto.Stock[] stocks = null;

	@Autowired
	StockRepo stockRepo;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public boolean deleteAllStocks() {
		stockRepo.deleteAll();
		return true;
	}

	@Override
	public boolean deleteStockById(int stockId) {
		if (stockRepo.existsById(stockId)) {
			stockRepo.deleteById(stockId);
			return true;
		}
		return false;
	}

	@Override
	public Stock updateStock(int stockId, Stock updateStock) {
		Optional<StockEntity> opStockEntity = stockRepo.findById(stockId);
		if (opStockEntity.isPresent()) {
			StockEntity stockEntity = opStockEntity.get();
			stockEntity.setMarket(updateStock.getMarket());
			stockEntity.setName(updateStock.getName());
			stockEntity.setPrice(updateStock.getPrice());
			stockRepo.save(stockEntity);
		}
		return null;

	}

	@Override
	public Stock createNewStock(Stock stock) {
		StockEntity stockEntity = convertDTOIntoEntity(stock);
		stockEntity = stockRepo.save(stockEntity);
		return convertEntityIntoDTO(stockEntity);
	}

	@Override
	public Stock getStockById(int stockId) {
		Optional<StockEntity> opStockEntity = stockRepo.findById(stockId);
		if (opStockEntity.isPresent()) {
			StockEntity stockEntity = opStockEntity.get();
			return convertEntityIntoDTO(stockEntity);
		}
		return null;

	}

	@Override
	public List<Stock> getAllStocks() {
		List<StockEntity> stockEntityList = stockRepo.findAll();
		List<Stock> stockDtoList = new ArrayList<Stock>();
		for (StockEntity stockEntity : stockEntityList) {
			Stock stock = convertEntityIntoDTO(stockEntity);
			stockDtoList.add(stock);
		}
		return stockDtoList;
	}

//	private StockEntity convertStockDTOIntoEntity(Stock stock) {
//		return new StockEntity(stock.getId(), stock.getMarket(), stock.getPrice());
//	}

	private StockEntity convertDTOIntoEntity(Stock stock) {
		TypeMap<Stock, StockEntity> typeMap = modelMapper.typeMap(Stock.class, StockEntity.class);
		typeMap.addMappings(mapper -> {
			mapper.map(stockDto -> stockDto.getMarket(), StockEntity::setMarket);
		});
		StockEntity stockEntity = modelMapper.map(stock, StockEntity.class);
		return stockEntity;
	}

	private Stock convertEntityIntoDTO(StockEntity stockEntity) {
		TypeMap<StockEntity, Stock> typeMap = modelMapper.typeMap(StockEntity.class, Stock.class);
		typeMap.addMappings(mapper -> {
			mapper.map(stockentity -> stockEntity.getMarket(), Stock::setMarket);
		});
		Stock stock = modelMapper.map(stockEntity, Stock.class);
		return stock;
	}
}
