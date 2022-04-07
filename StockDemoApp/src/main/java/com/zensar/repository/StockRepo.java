package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.enttity.StockEntity;

public interface StockRepo extends JpaRepository<StockEntity, Integer>{

}
