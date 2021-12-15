package com.sistventas.domain.service;

import java.util.List;

import com.sistventas.model.entity.Usuario;

public interface IUsuarioService {
	List<Usuario> obtener();
	Usuario obtenerPorId(Integer id);
	Usuario guardar(Usuario usuario);
	void eliminarPorId(Integer id);
}
