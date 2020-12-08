package ec.edu.ups.modelo;

import java.io.Serializable;

public class Productos implements Serializable {

	private int idProd;
	private String nomProd;
	private Double precProd;
	private int cantProd;
	private CatProducto catProd;
	private Empresa empresa;
	
	public Productos() {
		// TODO Auto-generated constructor stub
	}

	public Productos(int idProd, String nomProd, Double precProd, int cantProd) {
		super();
		this.idProd = idProd;
		this.nomProd = nomProd;
		this.precProd = precProd;
		this.cantProd = cantProd;
	}

	public int getIdProd() {
		return idProd;
	}

	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}

	public String getNomProd() {
		return nomProd;
	}

	public void setNomProd(String nomProd) {
		this.nomProd = nomProd;
	}

	public Double getPrecProd() {
		return precProd;
	}

	public void setPrecProd(Double precProd) {
		this.precProd = precProd;
	}

	public int getCantProd() {
		return cantProd;
	}

	public void setCantProd(int cantProd) {
		this.cantProd = cantProd;
	}

	public CatProducto getCatProd() {
		return catProd;
	}

	public void setCatProd(CatProducto catProd) {
		this.catProd = catProd;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		return "Productos [idProd=" + idProd + ", nomProd=" + nomProd + ", precProd=" + precProd + ", cantProd="
				+ cantProd + ", catProd=" + catProd + ", empresa=" + empresa + "]";
	}
	
	
	

}
