package com.rinconDelTaco.rincoTacosistema.persitence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {
	@Id
	@Column(name="cod_prod", columnDefinition = "CHAR(6)")
	private String codProd;
	@Column(name = "nom_prod", length = 45, nullable = false)
	private String nomProd;
	@Column(name = "desc_prod", length = 200, nullable = false)
	private String descProd;
	@Column(name = "prec_prod", columnDefinition = "DECIMAL(10, 2)", nullable = false)
	private double precProd;
	@Column(name = "ruta_img", length = 200, nullable = false)
	private String rutaImg;
	//FK's
	@Column(name = "cod_est_prod", columnDefinition = "CHAR(2)", nullable = false)
	private String codEstProd;
	@Column(name = "cod_cat_prod", columnDefinition = "CHAR(2)", nullable = false)
	private String codCatProd;
	
	@ManyToOne
	@JoinColumn(name = "cod_est_prod", insertable = false, updatable = false)
	private Estado_producto ref_estProd;
	
	@ManyToOne
	@JoinColumn(name = "cod_cat_prod", insertable = false, updatable = false)
	private Categoria_producto ref_catProd;

	
	public Producto() { }

	public Producto(String codProd, String nomProd, String descProd, double precProd, String rutaImg, String codEstProd,
					String codCatProd, Estado_producto ref_estProd, Categoria_producto ref_catProd) {
		super();
		this.codProd = codProd;
		this.nomProd = nomProd;
		this.descProd = descProd;
		this.precProd = precProd;
		this.rutaImg = rutaImg;
		this.codEstProd = codEstProd;
		this.codCatProd = codCatProd;
		this.ref_estProd = ref_estProd;
		this.ref_catProd = ref_catProd;
	}


	public String getCodProd() {
		return codProd;
	}

	public void setCodProd(String codProd) {
		this.codProd = codProd;
	}

	public String getNomProd() {
		return nomProd;
	}

	public void setNomProd(String nomProd) {
		this.nomProd = nomProd;
	}

	public String getDescProd() {
		return descProd;
	}

	public void setDescProd(String descProd) {
		this.descProd = descProd;
	}

	public double getPrecProd() {
		return precProd;
	}

	public void setPrecProd(double precProd) {
		this.precProd = precProd;
	}

	public String getRutaImg() {
		return rutaImg;
	}

	public void setRutaImg(String rutaImg) {
		//agregar carpeta a la nuta de la img
		this.rutaImg = "/static/Img/" + rutaImg;
	}

	public String getCodEstProd() {
		return codEstProd;
	}

	public void setCodEstProd(String codEstProd) {
		this.codEstProd = codEstProd;
	}

	public String getCodCatProd() {
		return codCatProd;
	}

	public void setCodCatProd(String codCatProd) {
		this.codCatProd = codCatProd;
	}

	public Estado_producto getRef_estProd() {
		return ref_estProd;
	}

	public void setRef_estProd(Estado_producto objEstProd) {
		this.ref_estProd = objEstProd;
	}

	public Categoria_producto getRef_catProd() {
		return ref_catProd;
	}

	public void setRef_catProd(Categoria_producto objCatProd) {
		this.ref_catProd = objCatProd;
	}		
}