package com.example.bankorange.form;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UserForm {
    @NotEmpty
    @NotNull
    @Length(min = 14, max = 14)
    @CPF
    private String cpf;

    @NotNull
    @NotEmpty
    @Length(min = 6, max = 30)
    private String nome;

    @NotNull
    @NotEmpty
    @Length(min = 11, max = 30)
    @Email
    private String email;

    @NotNull
    @NotEmpty
    @Length(min = 10, max = 10)
    private String dt_nascimento;
}
