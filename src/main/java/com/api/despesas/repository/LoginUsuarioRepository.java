package com.api.despesas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.despesas.model.LoginUsuario;

@Repository
public interface LoginUsuarioRepository extends JpaRepository<LoginUsuario, Long> {
	
	
}
