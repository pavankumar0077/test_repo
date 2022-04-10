package com.olx.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olx.dto.User;
import com.olx.entity.UserEntity;
import com.olx.repository.OlxRepo;


@Service
public class LoginServiceImpl implements LoginService {
	
	private static final User userEntity = null;
	private static final User user = null;
	
	@Autowired(required = false)
	OlxRepo olxRepo;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public String authenticate(User user) {
		return "A78DT";
	}

	@Override
	public boolean logout(String authToken) {
		return true;
	}
	

	@Override
	public User registerUser(User user) {
		UserEntity userEntity = convertDTOIntoEntity(user);
		userEntity = olxRepo.save(userEntity);
		return convertEntityIntoDTO(userEntity);
	}
	


	@Override
	public boolean tokenValidate(String authToken) {
		return true;
	}

	@Override
	public User getUser(User user) {
		return user;
	}

//	@Override
//	public User getUser(String authToken) {
//		return registerUser(null);
//	}
	
	
	private UserEntity convertDTOIntoEntity(User user) {
		TypeMap<User, UserEntity> typeMap = modelMapper.typeMap(User.class, UserEntity.class);
		typeMap.addMappings(mapper -> {
			mapper.map(userDto -> userDto.getUserName(), UserEntity::setUserName);
		});
		UserEntity userEntity = modelMapper.map(user, UserEntity.class);
		return userEntity;
	}

	private User convertEntityIntoDTO(UserEntity userEntity) {
		TypeMap<UserEntity, User> typeMap = modelMapper.typeMap(UserEntity.class, User.class);
		typeMap.addMappings(mapper -> {
			mapper.map(userentity -> userEntity.getUserName(), User::setUserName);
		});
		User user = modelMapper.map(userEntity, User.class);
		return user;
	}

	

}
