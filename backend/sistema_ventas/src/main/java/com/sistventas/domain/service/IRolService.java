package com.sistventas.domain.service;

import java.util.List;

import com.sistventas.model.entity.Rol;

public interface IRolService {
	
	List<Rol> obtener();
	Rol obtenerPorId(Integer id);
	Rol guardar(Rol rol);
	void eliminarPorId(Integer id);
	
}
