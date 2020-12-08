package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.Set;

public class Usuario implements Serializable{
	
	private int idUsu;
	private String nombreUsu;
	private String emailUsu;
	private String passUsu;
	private char tipoUsu;
	private Empresa empresa;
	private Set<Requerimiento> requerimientos;
	

	public Usuario() {
		
	}
	public Usuario(int idUsu, String nombreUsu, String emailUsu, String passUsu, char tipoUsu) {
		super();
		this.idUsu = idUsu;
		this.nombreUsu = nombreUsu;
		this.emailUsu = emailUsu;
		this.passUsu = passUsu;
		this.tipoUsu = tipoUsu;
	}
	
	public int getIdUsu() {
		return idUsu;
	}
	public void setIdUsu(int idUsu) {
		this.idUsu = idUsu;
	}
	public String getNombreUsu() {
		return nombreUsu;
	}
	public void setNombreUsu(String nombreUsu) {
		this.nombreUsu = nombreUsu;
	}
	public String getEmailUsu() {
		return emailUsu;
	}
	public void setEmailUsu(String emailUsu) {
		this.emailUsu = emailUsu;
	}
	public String getPassUsu() {
		return passUsu;
	}
	public void setPassUsu(String passUsu) {
		this.passUsu = passUsu;
	}
	public char getTipoUsu() {
		return tipoUsu;
	}
	public void setTipoUsu(char tipoUsu) {
		this.tipoUsu = tipoUsu;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public Set<Requerimiento> getRequerimientos() {
		return requerimientos;
	}
	public void setRequerimientos(Set<Requerimiento> requerimientos) {
		this.requerimientos = requerimientos;
	}
	
	@Override
	public String toString() {
		return "Usuario [idUsu=" + idUsu + ", nombreUsu=" + nombreUsu + ", emailUsu=" + emailUsu + ", passUsu="
				+ passUsu + ", tipoUsu=" + tipoUsu + ", empresa=" + empresa + ", requerimientos=" + requerimientos
				+ "]";
	}

	

}
