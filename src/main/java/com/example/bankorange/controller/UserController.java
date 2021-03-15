package com.example.bankorange.controller;

import com.example.bankorange.dto.UserDto;
import com.example.bankorange.form.UserForm;
import com.example.bankorange.model.User;
import com.example.bankorange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")

public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> getAll() {
		return userService.listar();
	}

	@PostMapping("/")
	public ResponseEntity<UserDto> add(@RequestBody @Valid UserForm form) {
		if (userService.isUserExists(form.getCpf())) {
			return ResponseEntity.badRequest().build();
		}

		UserDto userDto = userService.saveUser(form);

		return ResponseEntity.created(null).body(userDto);
	}
	
	@PutMapping("/{cpf}")
	public UserDto atualizaUser(@RequestBody UserForm form) {
		UserDto dto = userService.saveUser(form);
		return dto;
	}

	@DeleteMapping("/{cpf}")
	public ResponseEntity<Object> delete(@PathVariable String cpf) {
		if (userService.isUserExists(cpf)) {
			userService.deleteUser(cpf);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
