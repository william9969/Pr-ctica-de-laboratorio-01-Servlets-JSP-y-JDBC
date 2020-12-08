package ec.edu.ups.mysql.jdbc;

import ec.edu.ups.modelo.Requerimiento;
import ec.edu.ups.dao.RequerimientosDAO;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import ec.edu.ups.modelo.DetRequerimiento;
import ec.edu.ups.modelo.Productos;
import ec.edu.ups.modelo.Requerimiento;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.DetRequerimientoDAO;
import ec.edu.ups.dao.RequerimientosDAO;
import ec.edu.ups.dao.UsuarioDAO;
public class JDBCRequerimientosDAO extends JDBCGenericDAO<Requerimiento,Integer> implements RequerimientosDAO{

	@Override
	public void createTable() {
		jdbc2.update("DROP TABLE IF EXISTS Requerimiento");
		jdbc2.update("CREATE TABLE Requerimiento ("+ "IDREQ INT AUTO_INCREMENT, " + "FECREQ DATE ,"
		+ "AUTORIZAREQ VARCHAR(250), " + "OBSERREQ VARCHAR(250), " + "ESTADOREQ CHAR(1) , " + "IDUSEREQ INT, PRIMARY KEY (IDREQ) ,"
				+ "FOREIGN KEY (IDUSEREQ) REFERENCES USUARIO(IDUSU))");
		
		
	}

	@Override
	public void create(Requerimiento requerimiento) {
		ResultSet rs = jdbc1.query("SELECT max(IDREQ) FROM Requerimiento ");
		try {
			if(rs.next()) {
				try {
					int id=(Integer)rs.getInt(1)+1;
					SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
					jdbc2.update("INSERT Requerimiento VALUES ("+id+",'"+ formato.format(requerimiento.getFecReq().getTime()) + "', '"
					+requerimiento.getAutorizaReq()+ "' , '" +requerimiento.getObserReq()+ "','" + requerimiento.getEstadoReq()+ "', " + requerimiento.getUsuario().getIdUsu() + ")");
					//System.out.println("Producto Agregado");
				} catch (SQLException e) {
					System.out.println(e.getErrorCode());
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Requerimiento read(Integer id) {
		Requerimiento requerimiento = null;
		Usuario usuarioRequerimiento=null;
		ResultSet rsRequerimiento = jdbc1.query("SELECT * FROM Requerimiento WHERE IDREQ=" + id );
		try {
			while (rsRequerimiento.next()) {
				Calendar calendar =  new GregorianCalendar();
				calendar.setTime(rsRequerimiento.getDate("fecReq"));
				requerimiento = new Requerimiento(rsRequerimiento.getInt("idReq"),calendar, rsRequerimiento.getString("autorizaReq"), rsRequerimiento.getString("obserReq"), rsRequerimiento.getString("estadoReq").charAt(0));
				
				ResultSet rUsuEmp = jdbc2.query("SELECT * FROM usuario WHERE IDUSU="+rsRequerimiento.getInt("IDUSEREQ"));
				try {
					while(rUsuEmp.next()) {
						usuarioRequerimiento = new Usuario(rUsuEmp.getInt("idusu"),rUsuEmp.getString("nombreusu"),rUsuEmp.getString("emailusu"),rUsuEmp.getString("passusu"),rUsuEmp.getString("TIPOUSU").charAt(0));
					}
			
				} catch (Exception e) {
					System.out.println(">>>WARNING (JDBCRequerimientoDAO:usuarioRequerimiento): " + e.getMessage());
				}
				requerimiento.setUsuario(usuarioRequerimiento);
				requerimiento.setUsuario(usuarioRequerimiento);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCRequerimientoDAO:readByID): " + e.getMessage());
		}
		return requerimiento;
	}

	@Override
	public void update(Requerimiento requerimiento) {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		jdbc1.update("UPDATE Requerimiento SET fecReq = ' " + formato.format(requerimiento.getFecReq().getTime()) + "', autorizaReq = '" + requerimiento.getAutorizaReq()+ "', obserReq = '" 
				+ requerimiento.getObserReq() + "', estadoReq = '" +requerimiento.getEstadoReq() +"' WHERE idReq = "+requerimiento.getIdReq());
		
	}

	@Override
	public void delete(Requerimiento requerimiento) {
		if (requerimiento.getDetRequerimientos() != null ) {
			for (DetRequerimiento detReq : requerimiento.getDetRequerimientos()) {
				DAOFactory.getFactory().getDetRequerimientoDAO().delete(detReq);
			}
		}
		jdbc1.update("DELETE FROM Requerimiento WHERE idReq = " + requerimiento.getIdReq());
		
	}

	@Override
	public List<Requerimiento> find() {
		List<Requerimiento> list = new ArrayList<Requerimiento>();
		ResultSet rs = jdbc1.query("SELECT * FROM Requerimiento");
		try {
			while (rs.next()) {
				Calendar calendar =  new GregorianCalendar();
				calendar.setTime(rs.getDate("fecReq"));
				Requerimiento requerimiento = new Requerimiento(rs.getInt("idReq"), calendar, rs.getString("autorizaReq"), rs.getString("obserReq"), rs.getString("estadoReq").charAt(0));
				list.add(requerimiento);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCRequerimientoDAO:find): " + e.getMessage());
		}
		return list;
	}

	@Override
	public ArrayList<Requerimiento> findbyUserID(Integer userid) {
		
		ArrayList<Requerimiento> list = new ArrayList<Requerimiento>();
		ResultSet rsRequerimiento = jdbc2.query("SELECT * FROM Requerimiento WHERE IDUSEREQ=" + userid);
		try {
			while (rsRequerimiento.next()) {
				Calendar calendar =  new GregorianCalendar();
				calendar.setTime(rsRequerimiento.getDate("fecReq"));
				Requerimiento requerimiento = new Requerimiento(rsRequerimiento.getInt("idReq"),calendar, rsRequerimiento.getString("autorizaReq"), rsRequerimiento.getString("obserReq"), rsRequerimiento.getString("estadoReq").charAt(0));
				list.add(requerimiento);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCRequerimientoDAO:findbyUserID): " + e.getMessage());
		}
		return list;
	}

	@Override
	public int ultimoReqCreado() {
		ResultSet rs = jdbc1.query("SELECT max(IDREQ) FROM Requerimiento ");
		int var=0;
		try {
			if(rs.next()) {
				var = (Integer)rs.getInt(1);
				return var;	
			}
			
		}	catch (Exception e) {
				// TODO: handle exception
			}
		return var;	
	}

	@Override
	public ArrayList<Requerimiento> finbyEmpresaID(Integer empID) {
		Usuario usuarioReqEmp=null;
		ArrayList<Requerimiento> reqEmpresaLis = new ArrayList<Requerimiento>();
		ResultSet rsReqEmp = jdbc1.query("SELECT req.* FROM requerimiento req, usuario usu WHERE usu.IDEMPUSU="+empID+" and req.IDUSEREQ=usu.IDUSU");
		try {
			while (rsReqEmp.next()) {
				Calendar calendar =  new GregorianCalendar();
				calendar.setTime(rsReqEmp.getDate("fecReq"));
				Requerimiento requerimiento = new Requerimiento(rsReqEmp.getInt("idReq"),calendar, rsReqEmp.getString("autorizaReq"), rsReqEmp.getString("obserReq"), rsReqEmp.getString("estadoReq").charAt(0));
				
				ResultSet rUsuEmp = jdbc2.query("SELECT * FROM usuario WHERE IDUSU="+rsReqEmp.getInt("IDUSEREQ"));
				try {
					while (rUsuEmp.next()) {
						
						
						usuarioReqEmp = new Usuario(rUsuEmp.getInt("idusu"),rUsuEmp.getString("nombreusu"),rUsuEmp.getString("emailusu"),rUsuEmp.getString("passusu"),rUsuEmp.getString("TIPOUSU").charAt(0));
					}
					
				} catch (Exception e) {
					System.out.println(">>>WARNING (JDBCRequerimientoDAO:findbyUserID): " + e.getMessage());
				}
				requerimiento.setUsuario(usuarioReqEmp);
				reqEmpresaLis.add(requerimiento);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCRequerimientoDAO:findbyEmpresaID): " + e.getMessage());
		}
		//System.out.println("BASE DE DATOS"+reqEmpresaLis );
		return reqEmpresaLis;
	}

	/*@Override
	public ArrayList<Requerimiento> finbyUsuarioReqID(Integer usuID) {
		ArrayList<Requerimiento> reqUsuarioLis = new ArrayList<Requerimiento>();
		ResultSet rsReqEmp = jdbc1.query("SELECT * FROM requerimiento WHERE IDUSEREQ="+usuID);
		try {
			while (rsReqEmp.next()) {
				Calendar calendar =  new GregorianCalendar();
				calendar.setTime(rsReqEmp.getDate("fecReq"));
				Requerimiento requerimiento = new Requerimiento(rsReqEmp.getInt("idReq"),calendar, rsReqEmp.getString("autorizaReq"), rsReqEmp.getString("obserReq"), rsReqEmp.getString("estadoReq").charAt(0));		
				reqUsuarioLis.add(requerimiento);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCRequerimientoDAO:findbyUserID): " + e.getMessage());
		}
		return reqUsuarioLis;
	}*/

	

	

}
