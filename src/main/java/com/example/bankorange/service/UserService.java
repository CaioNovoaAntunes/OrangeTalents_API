package com.example.bankorange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.bankorange.model.User;
import com.example.bankorange.repository.UserRepository;

import java.util.List;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public List<User> listar() {
		return userRepository.findAll();
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public Boolean isUserExists(String cpf) {
		Boolean isCpfExists = userRepository.findByCpf(cpf) != null;
		if (isCpfExists) {
			return true;
		}
		return false;
	}

	public void deleteUser(String cpf) {
		userRepository.deleteByCpf(cpf);

	}
}
