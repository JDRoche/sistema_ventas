package com.sistventas.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistventas.domain.service.UsuarioServiceImpl;
import com.sistventas.model.entity.Usuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioServiceImpl _usuarioService;
	
	@GetMapping()
	public ResponseEntity<?> obtener() {
		try {
			return new ResponseEntity<>(_usuarioService.obtener(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("{\"Error\":\"No se pueden consultar los registros\"}", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable Integer id) {
		try {
			return new ResponseEntity<>(_usuarioService.obtenerPorId(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("{\"Error\":\"Error al colsultar el registro\"}", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping()
	public ResponseEntity<?> insertar(@RequestBody Usuario usuario) {
		try {
			return new ResponseEntity<>(_usuarioService.guardar(usuario), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("{\"Error\":\"Error al guardar el registro\"}", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping()
	public ResponseEntity<?> actualizar(@RequestBody Usuario usuario) {
		try {
			return new ResponseEntity<>(_usuarioService.guardar(usuario), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("{\"Error\":\"Error al guardar el registro\"}", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarPorId(@PathVariable Integer id) {
		try {
			_usuarioService.eliminarPorId(id);
			return new ResponseEntity<>("{\"Ok\":\"Registro eliminado\"}", HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>("{\"Error\":\"Error al eliminar el registro\"}", HttpStatus.NOT_FOUND);
		}
	}
	
}
