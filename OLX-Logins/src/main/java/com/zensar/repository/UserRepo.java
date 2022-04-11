package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {

}
