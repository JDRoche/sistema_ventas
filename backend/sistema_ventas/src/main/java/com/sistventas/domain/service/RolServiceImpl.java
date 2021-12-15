package com.sistventas.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistventas.model.dao.IRolDao;
import com.sistventas.model.entity.Rol;

@Service
public class RolServiceImpl implements IRolService {

	@Autowired
	private IRolDao _rolDao;
	
	@Override
	public List<Rol> obtener() {
		return (List<Rol>) _rolDao.findAll();
	}

	@Override
	public Rol obtenerPorId(Integer id) {
		return _rolDao.findById(id).orElse(null);
	}

	@Override
	public Rol guardar(Rol rol) {
		return _rolDao.save(rol);
	}

	@Override
	public void eliminarPorId(Integer id) {
		_rolDao.deleteById(id);
	}

	

}
