package com.rinconDelTaco.rincoTacosistema.persitence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="estado_producto")
public class Estado_producto {
	@Id
	@Column(name = "cod_est_prod", columnDefinition = "CHAR(2)")
	private String codEstProd;
	@Column(name = "desc_est_prod", length = 45, nullable = false)
	private String descEstProd;
	
	public Estado_producto() { }

	
	
	public String getCodEstProd() {
		return codEstProd;
	}

	public void setCodEstProd(String codEstProd) {
		this.codEstProd = codEstProd;
	}

	public String getDescEstProd() {
		return descEstProd;
	}

	public void setDescEstProd(String descEstProd) {
		this.descEstProd = descEstProd;
	}

}
