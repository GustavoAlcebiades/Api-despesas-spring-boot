package com.api.despesas.service;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.api.despesas.model.LoginUsuario;
import com.api.despesas.repository.LoginUsuarioRepository;

@Service
public class LoginUsuarioService {

	@Autowired
	private LoginUsuarioRepository loginUsuarioRepository;
	
	public List<LoginUsuario> getAllUsers(){
		
		return loginUsuarioRepository.findAll();
	
	}
	
	public Optional<LoginUsuario> getOneUser(long id){
		
		return loginUsuarioRepository.findById(id);
	}
	
	public LoginUsuario saveUser(LoginUsuario loginUsuario){
		
		return loginUsuarioRepository.save(loginUsuario);
	}
	
	@ExceptionHandler
	public Optional<LoginUsuario> verifyIfExists(long id) throws LoginException {
		Optional<LoginUsuario> loginUsuario = loginUsuarioRepository.findById(id);

		if (loginUsuario == null) {
			throw new LoginException("Usuário não do id" + id + "não foi encontrado");
		}
		return loginUsuario;
	}

}
