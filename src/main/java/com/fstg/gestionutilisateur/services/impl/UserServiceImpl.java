package com.fstg.gestionutilisateur.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fstg.gestionutilisateur.entities.UserEntity;
import com.fstg.gestionutilisateur.repositories.UserRepository;
import com.fstg.gestionutilisateur.services.UserServices;
import com.fstg.gestionutilisateur.shared.Utils;
import com.fstg.gestionutilisateur.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserServices {

	@Autowired
	UserRepository userRepository;
	@Autowired
	Utils util;
	@Autowired
	BCryptPasswordEncoder BCryptPasswordEncoder;

	@Override
	public UserDto create(UserDto userDto) {
		UserEntity usercheck = userRepository.findByEmail(userDto.getEmail());
		if (usercheck != null)
			throw new RuntimeException("User Already Existe");
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDto, userEntity);
		userEntity.setEncryptedPassword(BCryptPasswordEncoder.encode(userDto.getPassword()));
		userEntity.setUserId(util.generateUserId(32));
		UserEntity userEntity2 = userRepository.save(userEntity);
		UserDto dto = new UserDto();
		BeanUtils.copyProperties(userEntity2, dto);
		return dto;
	}

	@Override
	public UserDto getUser(String email) {
		
		UserEntity usercheck = userRepository.findByEmail(email);
		if (usercheck == null)
			throw new RuntimeException("User dosn't Existe");
		UserDto dto = new UserDto();
		BeanUtils.copyProperties(usercheck,dto);
		return dto;
	}

	@Override
	public UserDto findByUserId(String userId) {
		UserEntity userById=userRepository.findByUserId(userId);
		if(userById==null) throw new RuntimeException("user with "+userId+" not found");
		UserDto dto = new UserDto();
		BeanUtils.copyProperties(userById,dto);
		return dto;
		
	}

	@Override
	public UserDto updateUser(UserDto userDto, String id) {
		UserEntity userById=userRepository.findByUserId(id);
		if(userById==null) throw new RuntimeException("user with "+id+" not found");
//		userById.setEmail(userDto.getEmail());
		userById.setFistName(userDto.getFistName());
		userById.setLastName(userDto.getLastName());
//		userById.setEncryptedPassword(BCryptPasswordEncoder.encode(userDto.getPassword()));
		UserEntity userEntityupdated=userRepository.save(userById);
		UserDto dto = new UserDto();
		BeanUtils.copyProperties(userEntityupdated,dto);
		return dto;
	}

	@Override
	public void deleteUser(String userId) {
		UserEntity userById=userRepository.findByUserId(userId);
		if(userById==null) throw new RuntimeException("user with "+userId+" not found");
		userRepository.delete(userById);
	}

	@Override
	public List<UserDto> findAll(int page,int limit) {
		
		if(page>0) page-=1;
		Pageable pageable=PageRequest.of(page, limit);
		Page<UserEntity> users=userRepository.findAll(pageable);
		List<UserEntity> result=users.getContent();
		List<UserDto> usersdto=new ArrayList<>();
		for(UserEntity userEntity:result) {
			UserDto userDto=new UserDto();
			BeanUtils.copyProperties(userEntity,userDto);
			usersdto.add(userDto);
		}
		
		System.out.println("size is "+usersdto.size());
		return usersdto;
	}

}
