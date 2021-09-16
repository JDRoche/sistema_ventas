package com.sistventas.business.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sistventas.model.dao.IClienteDao;
import com.sistventas.model.entity.Cliente;

public class ClienteDaoImpl implements IClienteService{

	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	public Boolean delete(Long id) {
		Cliente cliente = clienteDao.findById(id).orElse(null);
		if(cliente != null) {
			clienteDao.deleteById(id);
			return true;
		}
		
		return false;
		
	}

	@Override
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	public Optional<Cliente> findById(Long id) {
		return clienteDao.findById(id);
	}

	
}
