package ec.edu.ups.modelo;

import java.io.*;
import java.util.Set;

public class CatProducto implements Serializable{

	private int idCatProd;
	private String nomCatProd;
	private Set<Productos> productos;
	
	
	public CatProducto() {
		// TODO Auto-generated constructor stub
		
	}


	public CatProducto(int idCatProd, String nomCatProd) {
		super();
		this.idCatProd = idCatProd;
		this.nomCatProd = nomCatProd;
	}


	public int getIdCatProd() {
		return idCatProd;
	}


	public void setIdCatProd(int idCatProd) {
		this.idCatProd = idCatProd;
	}


	public String getNomCatProd() {
		return nomCatProd;
	}


	public void setNomCatProd(String nomCatProd) {
		this.nomCatProd = nomCatProd;
	}


	public Set<Productos> getProductos() {
		return productos;
	}


	public void setProductos(Set<Productos> productos) {
		this.productos = productos;
	}


	@Override
	public String toString() {
		return "CatProducto [idCatProd=" + idCatProd + ", nomCatProd=" + nomCatProd + ", productos=" + productos + "]";
	}
	
	

}
