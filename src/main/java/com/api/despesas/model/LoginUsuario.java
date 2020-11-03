package com.api.despesas.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class LoginUsuario {

	@Id
	public long id;

	@NotEmpty(message = "Método inválido")
	public String nome;
	@NotEmpty(message = "Método Inválido")
	public String sobrenome;
	@Email(message = "Caracteres inválidos")
	public String email;
	@NotEmpty(message = "Método Inválido")
	public String senha;

}
