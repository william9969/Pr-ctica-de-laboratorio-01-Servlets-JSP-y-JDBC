package ec.edu.ups.modelo;

public class DetRequerimiento {
	private int idDetReq;
	private int cantProDetReq;//Cantidad que Requiere del Producto
	private int idProdDetReq;//Id del Producto que Requiere
	private int invenProdDetReq;//Inventario del producto que Requiere
	private double precProdDetReq;// Precio del producto que Requiere
	private int desProdDetReq;//Porcentaje de Descuento
	private Requerimiento requerimiento; 
	
	public DetRequerimiento() {
		// TODO Auto-generated constructor stub
	}

	public DetRequerimiento(int idDetReq, int cantProDetReq, int idProdDetReq, int invenProdDetReq,
			double precProdDetReq, int desProdDetReq) {
		super();
		this.idDetReq = idDetReq;
		this.cantProDetReq = cantProDetReq;
		this.idProdDetReq = idProdDetReq;
		this.invenProdDetReq = invenProdDetReq;
		this.precProdDetReq = precProdDetReq;
		this.desProdDetReq = desProdDetReq;
	}

	public int getIdDetReq() {
		return idDetReq;
	}

	public void setIdDetReq(int idDetReq) {
		this.idDetReq = idDetReq;
	}

	public int getCantProDetReq() {
		return cantProDetReq;
	}

	public void setCantProDetReq(int cantProDetReq) {
		this.cantProDetReq = cantProDetReq;
	}

	public int getIdProdDetReq() {
		return idProdDetReq;
	}

	public void setIdProdDetReq(int idProdDetReq) {
		this.idProdDetReq = idProdDetReq;
	}

	public int getInvenProdDetReq() {
		return invenProdDetReq;
	}

	public void setInvenProdDetReq(int invenProdDetReq) {
		this.invenProdDetReq = invenProdDetReq;
	}

	public double getPrecProdDetReq() {
		return precProdDetReq;
	}

	public void setPrecProdDetReq(double precProdDetReq) {
		this.precProdDetReq = precProdDetReq;
	}

	public int getDesProdDetReq() {
		return desProdDetReq;
	}

	public void setDesProdDetReq(int desProdDetReq) {
		this.desProdDetReq = desProdDetReq;
	}

	public Requerimiento getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(Requerimiento requerimiento) {
		this.requerimiento = requerimiento;
	}
	
	@Override
	public String toString() {
		return "DetRequerimiento [idDetReq=" + idDetReq + ", cantProDetReq=" + cantProDetReq + ", idProdDetReq="
				+ idProdDetReq + ", invenProdDetReq=" + invenProdDetReq + ", precProdDetReq=" + precProdDetReq
				+ ", desProdDetReq=" + desProdDetReq + ", requerimiento=" + requerimiento + "]";
	}
	
	

}
