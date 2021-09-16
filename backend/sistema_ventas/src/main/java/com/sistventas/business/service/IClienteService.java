package com.sistventas.business.service;

import java.util.List;
import java.util.Optional;

import com.sistventas.model.entity.Cliente;

public interface IClienteService {
	
	Cliente save (Cliente cliente);
	Boolean delete(Long id);
	List<Cliente> findAll();
	Optional<Cliente> findById(Long id);
	
}