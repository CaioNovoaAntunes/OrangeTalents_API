package com.br.trivial.bank.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="trivialbanco")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class TrivialModel{
@Id
private String cpf;
private String nome;
private String email;
private String telefone;
private Date dt_nascimento;

}
