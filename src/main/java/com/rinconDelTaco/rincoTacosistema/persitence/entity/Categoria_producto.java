package com.rinconDelTaco.rincoTacosistema.persitence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="categoria_producto")
public class Categoria_producto {
	@Id
	@Column(name = "cod_cat_prod", columnDefinition = "CHAR(2)")
	private String codCatProd;
	@Column(name = "desc_cat_prod", length = 50, nullable = false)
	private String descCatProd;
	
	public Categoria_producto() {} 
	
	

	public String getCodCatProd() {
		return codCatProd;
	}

	public void setCodCatProd(String codCatProd) {
		this.codCatProd = codCatProd;
	}

	public String getDescCatProd() {
		return descCatProd;
	}

	public void setDescCatProd(String descCatProd) {
		this.descCatProd = descCatProd;
	}
	
}