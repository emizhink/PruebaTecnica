package com.pruebatecnica.app.models.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7589287820342607391L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long item;

	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String cantidad;
	
	@NotEmpty
	private String codigoInventario;

	/**
	 * @return the item
	 */
	public Long getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(Long item) {
		this.item = item;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the cantidad
	 */
	public String getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the codigoInventario
	 */
	public String getCodigoInventario() {
		return codigoInventario;
	}

	/**
	 * @param codigoInventario the codigoInventario to set
	 */
	public void setCodigoInventario(String codigoInventario) {
		this.codigoInventario = codigoInventario;
	}


	
}
