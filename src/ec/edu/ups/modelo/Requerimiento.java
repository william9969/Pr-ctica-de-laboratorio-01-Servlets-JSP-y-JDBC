package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

public class Requerimiento implements Serializable{
	private int idReq;
	private Calendar fecReq;
	private String autorizaReq;
	private String obserReq;
	private char estadoReq;
	private Usuario usuario;
	private Set<DetRequerimiento> detRequerimientos;
	
	public Requerimiento() {
		// TODO Auto-generated constructor stub
	}

	public Requerimiento(int idReq, Calendar fecReq, String autorizaReq, String obserReq, char estadoReq) {
		super();
		this.idReq = idReq;
		this.fecReq = fecReq;
		this.autorizaReq = autorizaReq;
		this.obserReq = obserReq;
		this.estadoReq = estadoReq;
	}

	public int getIdReq() {
		return idReq;
	}

	public void setIdReq(int idReq) {
		this.idReq = idReq;
	}

	public Calendar getFecReq() {
		return fecReq;
	}

	public void setFecReq(Calendar fecReq) {
		this.fecReq = fecReq;
	}

	public String getAutorizaReq() {
		return autorizaReq;
	}

	public void setAutorizaReq(String autorizaReq) {
		this.autorizaReq = autorizaReq;
	}

	public String getObserReq() {
		return obserReq;
	}

	public void setObserReq(String obserReq) {
		this.obserReq = obserReq;
	}

	public char getEstadoReq() {
		return estadoReq;
	}

	public void setEstadoReq(char estadoReq) {
		this.estadoReq = estadoReq;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<DetRequerimiento> getDetRequerimientos() {
		return detRequerimientos;
	}

	public void setDetRequerimientos(Set<DetRequerimiento> detRequerimientos) {
		this.detRequerimientos = detRequerimientos;
	}

	@Override
	public String toString() {
		return "Requerimiento [idReq=" + idReq + ", fecReq=" + fecReq + ", autorizaReq=" + autorizaReq + ", obserReq="
				+ obserReq + ", estadoReq=" + estadoReq + ", usuario=" + usuario + ", detRequerimientos="
				+ detRequerimientos + "]";
	}

	
}
