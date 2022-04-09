package com.zensar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zensar.enttity.StockEntity;

public interface StockRepo extends JpaRepository<StockEntity, Integer> {

	// JPA Repo is only for basic methods
	// If we are writing repo methods then we have follow conventions for sure if not we will get errors
	List<StockEntity> findByName(String stockName); // Here we are following convention Spring Data JPA

	@Query(value = "SELECT se FROM StockEntity AS se WHERE se.name=:stockName") // JPQL // We can fire queries on Entity // Class using JPQL ( It fires on// StockEntity not on DB table )
	List<StockEntity> getStocksByName(String stockName); // Here not need to follow convetion

	List<StockEntity> findByMarketname(String marketname);
	
	@Query(value = "SELECT * FROM STOCKS WHERE name=:stockName", nativeQuery = true) // Normal SQL query we see only table name
	List<StockEntity> getStocksByNameSQL(String stockName);
	
	
	
	List<StockEntity> findByNameContains(String nameLike);
	// Contains, Containing, IsContaining
	List<StockEntity> findByNameContaining(String nameLike);
	List<StockEntity> findByNameIsContaining(String nameLike);
	
//	@Query(value = "SELECT se FROM StockEntity AS se WHERE se.name LIKE ':nameLike'") // JPQL
//	List<StockEntity> getByNameLikeQuery(String nameLike);
	
	@Query(value="SELECT se FROM StockEntity AS se WHERE se.name LIKE %:nameLike%")  // JPQL
	List<StockEntity> getByNameLikeQuery(String nameLike);
	
//	@Query(value = "SELECT * FROM STOCK WHERE name LIKE = '%' ", nativeQuery = true)
//	List<StockEntity> getByNameLikeQuerySQL(String nameLike);
	
	
	List<StockEntity> findByOrderByNameAsc();
	List<StockEntity> findByOrderByNameDesc();
	
	@Query(value = "SELECT se FROM StockEntity AS se ORDER BY se.name")
	List<StockEntity> sortStoksByNameAsc();
	
	@Query(value = "SELECT se FROM StockEntity AS se ORDER BY se.name DESC")
	List<StockEntity> sortStoksByNameDesc();
	
	
	
}
