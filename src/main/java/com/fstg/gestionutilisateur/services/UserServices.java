package com.fstg.gestionutilisateur.services;

import java.util.List;

import com.fstg.gestionutilisateur.shared.dto.UserDto;

public interface UserServices {
	
	UserDto create(UserDto userDto);
	UserDto getUser(String email);
    UserDto findByUserId(String userId);
    UserDto updateUser(UserDto userDto,String id);
    void deleteUser(String userId);
    public List<UserDto> findAll(int page,int limit);

}
