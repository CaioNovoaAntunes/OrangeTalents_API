package com.example.bankorange.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankorange.model.User;
import com.example.bankorange.service.UserService;

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
	public ResponseEntity<User> add(@RequestBody @Valid User user) {
		if (userService.isUserExists(user.getCpf())) {
			return ResponseEntity.badRequest().body(new User());
		}
		return ResponseEntity.created(null).body(userService.saveUser(user));
	}
	
	@PutMapping("/{cpf}")
	public User atualizaUser(@RequestBody User user) {
		 return userService.saveUser(user);
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
