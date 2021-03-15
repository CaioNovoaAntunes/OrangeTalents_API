package com.example.bankorange.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
	@Id
	@Column(name = "cpf", unique = true)
	private String cpf;

	private String nome;

	@Column(name = "email", unique = true)
	private String email;

	private String dt_nascimento;
}