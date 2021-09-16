package com.sistventas.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.sistventas.model.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{

}
