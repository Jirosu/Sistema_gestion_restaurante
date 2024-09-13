package com.rinconDelTaco.rincoTacosistema.persitence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	@Column(name = "cod_usu", columnDefinition = "CHAR(8)")
	private String codUsu;
	@Column(name="nom_usu", length = 45, nullable = false)
	private String nomUsu;
	@Column(name = "ape_usu", length = 45, nullable = false)
	private String apeUsu;
	@Column(length = 30, nullable = false)
	private String usuario;
	@Column(length = 80, nullable = false)
	private String contrasena;
	@Column(name = "rol_usu", length = 13, nullable = false)
	private String rolUsu;
	
	public Usuario() { }

	
	
	public String getCodUsu() {
		return codUsu;
	}

	public void setCodUsu(String codUsu) {
		this.codUsu = codUsu;
	}

	public String getNomUsu() {
		return nomUsu;
	}

	public void setNomUsu(String nomUsu) {
		this.nomUsu = nomUsu;
	}

	public String getApeUsu() {
		return apeUsu;
	}

	public void setApeUsu(String apeUsu) {
		this.apeUsu = apeUsu;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getRolUsu() {
		return rolUsu;
	}

	public void setRolUsu(String rolUsu) {
		this.rolUsu = rolUsu;
	}
	
}