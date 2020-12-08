package ec.edu.ups.mysql.jdbc;

import ec.edu.ups.dao.GenericDAO;
public abstract class JDBCGenericDAO<T,ID> implements GenericDAO<T,ID>  {
	
	protected ContextJDBC jdbc1 = ContextJDBC.getJDBC1();
	protected ContextJDBC jdbc2 = ContextJDBC.getJDBC2();
}
