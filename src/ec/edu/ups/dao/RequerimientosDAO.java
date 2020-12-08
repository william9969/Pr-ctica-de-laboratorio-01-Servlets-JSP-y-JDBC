package ec.edu.ups.dao;

import java.util.ArrayList;
import java.util.Set;
import ec.edu.ups.modelo.Requerimiento;

public interface RequerimientosDAO extends GenericDAO<Requerimiento, Integer>{
	public abstract ArrayList<Requerimiento> findbyUserID(Integer userid);
	public abstract int ultimoReqCreado ();
	
	//////////////SELECT * FROM jee.requerimiento req, jee.usuario usu WHERE usu.IDEMPUSU=3 and req.IDUSEREQ=usu.IDUSU;
	public abstract ArrayList<Requerimiento> finbyEmpresaID(Integer empID);
	
	//public abstract ArrayList<Requerimiento> finbyUsuarioReqID(Integer usuID);
}
