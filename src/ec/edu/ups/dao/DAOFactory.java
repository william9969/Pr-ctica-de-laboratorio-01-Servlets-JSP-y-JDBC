package ec.edu.ups.dao;

public abstract class DAOFactory {
	
	protected static DAOFactory factory = new JDBCDAOFactory();
	
	public static DAOFactory getFactory() {
		return factory;
	}
	
	public abstract void createTables();

	public abstract CatProductoDAO getCatProductoDAO();

	public abstract DetRequerimientoDAO getDetRequerimientoDAO();

	public abstract EmpresaDAO getEmpresaDAO();

	public abstract ProductosDAO getProductosDAO();

	public abstract RequerimientosDAO getRequerimientosDAO();
	
	public abstract UsuarioDAO getUsuarioDAO();
}
