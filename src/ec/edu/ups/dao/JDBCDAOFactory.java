package ec.edu.ups.dao;

import ec.edu.ups.mysql.jdbc.*;

public class JDBCDAOFactory extends DAOFactory{

	
	
	@Override
	public void createTables() {
		this.getCatProductoDAO().createTable();
		this.getDetRequerimientoDAO().createTable();
		this.getEmpresaDAO().createTable();
		this.getProductosDAO().createTable();
		this.getRequerimientosDAO().createTable();
		this.getUsuarioDAO().createTable();
		
	}

	@Override
	public CatProductoDAO getCatProductoDAO() {
		// TODO Auto-generated method stub
		return new JDBCCatProductoDAO();
	}

	@Override
	public DetRequerimientoDAO getDetRequerimientoDAO() {
		// TODO Auto-generated method stub
		return new JDBCDetRequerimientoDAO();
	}

	@Override
	public EmpresaDAO getEmpresaDAO() {
		// TODO Auto-generated method stub
		return new JDBCEmpresaDAO();
	}

	@Override
	public ProductosDAO getProductosDAO() {
		// TODO Auto-generated method stub
		return new JDBCProductosDAO();
	}

	@Override
	public RequerimientosDAO getRequerimientosDAO() {
		// TODO Auto-generated method stub
		return new JDBCRequerimientosDAO();
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new JDBCUsuarioDAO();
	}
	
	

}
