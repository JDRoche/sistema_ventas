package com.sistventas.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Integer idUsuario;
	private String nombre;
	private String usuario;
	private String contrasena;
	@Column(name = "fecha_registro")
	private LocalDate fechaRegistro;
	@Column(name = "ultimo_ingreso")
	private LocalDate ultimoIngreso;
	@Column(name = "url_foto")
	private String urlFoto;
	private Boolean estado;
	
	@ManyToOne
	@JoinColumn(name = "idRol")
	private Rol rol;
	
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUsusario() {
		return usuario;
	}
	public void setUsusario(String ususario) {
		this.usuario = ususario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public LocalDate getUltimoIngreso() {
		return ultimoIngreso;
	}
	public void setUltimoIngreso(LocalDate ultimoIngreso) {
		this.ultimoIngreso = ultimoIngreso;
	}
	public String getUrlFoto() {
		return urlFoto;
	}
	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}

}
