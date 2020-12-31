package com.example.bankorange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bankorange.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByCpf(String cpf);
	
	void deleteByCpf(String cpf);

}