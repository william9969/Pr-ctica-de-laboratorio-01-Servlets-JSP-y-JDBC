package ec.edu.ups.dao;
import java.util.ArrayList;
import java.util.Set;

import ec.edu.ups.modelo.DetRequerimiento;
import ec.edu.ups.mysql.jdbc.JDBCDetRequerimientoDAO;

public interface DetRequerimientoDAO extends GenericDAO<DetRequerimiento,Integer>{
	public abstract Set<DetRequerimiento> finByRequerimientoID(Integer idRequerimiento);
}
