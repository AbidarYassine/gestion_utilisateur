package com.fstg.gestionutilisateur.repositories;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.fstg.gestionutilisateur.entities.UserEntity;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {

	public UserEntity findByEmail(String email);
	public UserEntity findByUserId(String userId);

}
