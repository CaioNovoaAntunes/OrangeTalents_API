package com.example.bankorange.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

	@Id
	@NotEmpty
	@NotNull
	@Length(min = 14, max = 14)
	@Column(name = "cpf", unique = true)
	private String cpf;
	@NotNull
	@NotEmpty
	@Length(min = 6, max = 30)
	private String nome;
	@NotNull
	@NotEmpty
	@Length(min = 11, max = 30)
	@Column(name = "email", unique = true)
	private String email;
	@NotNull
	@NotEmpty
	@Length(min = 10, max = 10)
	private String dt_nascimento;

}