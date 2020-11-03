package com.api.despesas.controller;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.LoginException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.despesas.model.LoginUsuario;
import com.api.despesas.repository.LoginUsuarioRepository;
import com.api.despesas.service.LoginUsuarioService;

@RestController
@RequestMapping("/login")
public class LoginUsuarioController {

	@Autowired
	private LoginUsuarioRepository loginUsuarioRepository;

	@Autowired
	private LoginUsuarioService loginUsuarioService;

	@GetMapping("/usuarios")
	public ResponseEntity<List<LoginUsuario>> getUsers() {

		List<LoginUsuario> loginUsuario = loginUsuarioService.getAllUsers();
		if (loginUsuario.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<LoginUsuario>>(loginUsuario, HttpStatus.OK);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<LoginUsuario> OneUser(@PathVariable(value = "id") long id) throws LoginException {
		Optional<LoginUsuario> usuario = loginUsuarioRepository.findById(id);

		if (!usuario.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<LoginUsuario>(usuario.get(), HttpStatus.OK);

		}

	}

	@PostMapping("/save")
	public ResponseEntity<LoginUsuario> saveUsers(@RequestBody @Valid LoginUsuario loginUsuario) {

		return new ResponseEntity<LoginUsuario>(loginUsuarioRepository.save(loginUsuario), HttpStatus.CREATED);
	}

}
