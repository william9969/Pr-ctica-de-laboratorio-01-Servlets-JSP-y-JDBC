package ec.edu.ups.modelo;

import java.io.*;
import java.util.*;

public class Empresa implements Serializable {


	
	private int idEmp;
	private String nomEmp;
	private String dirEmp;
	private Set<Usuario> usuario;
	private Set<Productos> productos; 
	
	public Empresa() {
		// TODO Auto-generated constructor stub
	}

	
	public Empresa(int idEmp, String nomEmp, String dirEmp) {
		super();
		this.idEmp = idEmp;
		this.nomEmp = nomEmp;
		this.dirEmp = dirEmp;
	}


	public int getIdEmp() {
		return idEmp;
	}

	public void setIdEmp(int idEmp) {
		this.idEmp = idEmp;
	}

	public String getNomEmp() {
		return nomEmp;
	}

	public void setNomEmp(String nomEmp) {
		this.nomEmp = nomEmp;
	}

	public String getDirEmp() {
		return dirEmp;
	}

	public void setDirEmp(String dirEmp) {
		this.dirEmp = dirEmp;
	}
	

	public Set<Usuario> getUsuario() {
		return usuario;
	}


	public void setUsuario(Set<Usuario> usuario) {
		this.usuario = usuario;
	}


	public Set<Productos> getProductos() {
		return productos;
	}


	public void setProductos(Set<Productos> productos) {
		this.productos = productos;
	}


	@Override
	public String toString() {
		return "Empresa [idEmp=" + idEmp + ", nomEmp=" + nomEmp + ", dirEmp=" + dirEmp + ", productos=" + productos
				+ "]";
	}


	
	
	
}
