package com.songhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.songhub.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);
	

}
