package com.sistventas.domain.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sistventas.model.dao.IUsuarioDao;
import com.sistventas.model.entity.Rol;
import com.sistventas.model.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService{//, UserDetailsService{

	@Autowired
	private IUsuarioDao _usuarioDao;
	
	@Autowired
	private RolServiceImpl _rolService;
	
	/*@Autowired
	private BCryptPasswordEncoder encoder;*/
	
	@Override
	public List<Usuario> obtener() {
		return (List<Usuario>) _usuarioDao.findAll();
	}

	@Override
	public Usuario obtenerPorId(Integer id) {
		return _usuarioDao.findById(id).orElse(null);
	}

	@Override
	public Usuario guardar(Usuario usuario) {
		if(obtenerPorId(usuario.getIdUsuario()) == null) {
			usuario.setFechaRegistro(LocalDate.now());
			usuario.setEstado(true);
		}
		//usuario.setContrasena(encoder.encode(usuario.getContrasena()));
		return _usuarioDao.save(usuario);
	}

	@Override
	public void eliminarPorId(Integer id) {
		_usuarioDao.deleteById(id);
	}

	/*@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		List<GrantedAuthority> rolesS = new ArrayList<>();
		Usuario usuario = _usuarioDao.findByUsuario(username);
		List<Rol> roles = _rolService.obtener();
		
		roles.forEach(rol -> {
			rolesS.add(new SimpleGrantedAuthority(rol.getNombre()));
		});
		
		UserDetails userDet = new User(usuario.getUsuario() ,usuario.getContrasena(), rolesS);
		
		return userDet;
	}*/

	

}
