package com.sistventas.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.sistventas.model.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Integer> {
	
	Usuario findByUsuario(String usuario);

}
