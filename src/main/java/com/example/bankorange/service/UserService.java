package com.example.bankorange.service;

import com.example.bankorange.dto.UserDto;
import com.example.bankorange.form.UserForm;
import com.example.bankorange.model.User;
import com.example.bankorange.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public List<User> listar() {
		return userRepository.findAll();
	}

	public UserDto saveUser(UserForm form) {
		User user = new User();

		user.setCpf(form.getCpf());
		user.setEmail(form.getEmail());
		user.setDt_nascimento(form.getDt_nascimento());
		user.setNome(form.getNome());

		userRepository.save(user);

		return new UserDto(user);
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
