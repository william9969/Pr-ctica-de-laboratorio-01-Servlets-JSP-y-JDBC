package ec.edu.ups.mysql.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ec.edu.ups.dao.DetRequerimientoDAO;
import ec.edu.ups.modelo.DetRequerimiento;
import ec.edu.ups.modelo.Requerimiento;
public class JDBCDetRequerimientoDAO extends JDBCGenericDAO<DetRequerimiento,Integer> implements DetRequerimientoDAO{ 

	@Override
	public void createTable() {
		jdbc2.update("DROP TABLE IF EXISTS DetRequerimiento");
		jdbc2.update("CREATE TABLE DetRequerimiento (IDDETREQ INT AUTO_INCREMENT, CANTPRODETREQ INT, "
				+ " IDPRODDETREQ INT, INVENPRODDETREQ INT, PRECPRODDETREQ DECIMAL(4,2) , "
				+ " DESPRODDETREQ INT, IDREQDETREQ INT, PRIMARY KEY (IDDETREQ) ,"
				+ " FOREIGN KEY(IDREQDETREQ) REFERENCES Requerimiento(IDREQ)) ");
		
	}

	@Override
	public void create(DetRequerimiento detReq) {
		
		
		ResultSet rs = jdbc1.query("SELECT max(IDDETREQ) FROM DetRequerimiento ");
		try {
			if(rs.next()) {
				try {
					int id=(Integer)rs.getInt(1)+1;
					jdbc2.update("INSERT DetRequerimiento VALUES ( "+id+"," +detReq.getCantProDetReq()+ ", " 
							+  detReq.getIdProdDetReq() + ", " + detReq.getInvenProdDetReq()+ ", " + detReq.getPrecProdDetReq() + ", " 
							+  detReq.getDesProdDetReq() + ", " +detReq.getRequerimiento().getIdReq() +")");
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
	public DetRequerimiento read(Integer id) {
		DetRequerimiento detReq = null;
		ResultSet rsDetReq = jdbc1.query("SELECT * FROM DetRequerimiento WHERE iddetreq" + id);
		try {
			if (rsDetReq != null && rsDetReq.next()) {
				detReq =  new DetRequerimiento(rsDetReq.getInt("iddetreq"), rsDetReq.getInt("cantProdDetReq"), rsDetReq.getInt("idProdDetReq"),
						rsDetReq.getInt("inventProdDetReq"), rsDetReq.getDouble("precProdDetReq"), rsDetReq.getInt("desProdDetReq"));
				ResultSet rsReq = jdbc2.query("SELECT * FROM Requerimiento WHERE id ="+rsDetReq.getInt("idReqDetReq"));
				if (rsReq != null && rsReq.next()) {
					Calendar calendar = new GregorianCalendar();
					calendar.setTime(rsReq.getDate("date"));
					Requerimiento reque = new Requerimiento(rsReq.getInt("idReq"), calendar,rsReq.getString("autorizaReq"), rsReq.getString("obserReq"), rsReq.getString("estadoReq").charAt(0));
					
					detReq.setRequerimiento(reque);
				}
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCDetRequerimientoDAO:read): " + e.getMessage());
		}
		if (detReq == null) {
			return null;
		}
			return detReq;
	}

	@Override
	public void update(DetRequerimiento detReq) {
		jdbc1.update("UPDATE DetRequerimiento SET cantProdDetReq = "+ detReq.getCantProDetReq()+" ,idProdDetReq = "+detReq.getIdProdDetReq()
		+ ", inventProdDetReq = " +detReq.getInvenProdDetReq() + ", precProdDetReq = " + detReq.getPrecProdDetReq() + ", desProdDetReq = " + detReq.getDesProdDetReq()+ "' WHERE iddetreq = "+ detReq.getIdDetReq());
		
	}

	@Override
	public void delete(DetRequerimiento detReq) {
		jdbc1.update("DELETE FROM DetRequerimiento WHERE iddetreq = "+detReq.getIdDetReq());
	}

	@Override
	public List<DetRequerimiento> find() {
		List<DetRequerimiento> list = new ArrayList<DetRequerimiento>();
		ResultSet rsDetReq = jdbc1.query("SELECT * FROM DetRequerimiento");
		try {
			while (rsDetReq.next()) {
				DetRequerimiento detReq = new DetRequerimiento(rsDetReq.getInt("iddetreq"), rsDetReq.getInt("cantProdDetReq"), rsDetReq.getInt("idProdDetReq"),
						rsDetReq.getInt("inventProdDetReq"), rsDetReq.getDouble("precProdDetReq"), rsDetReq.getInt("desProdDetReq"));
				/*	ResultSet rsReq = jdbc2.query("SELECT * FROM Requerimiento WHERE id ="+rsDetReq.getInt("idReqDetReq"));
				if (rsReq != null && rsReq.next()) {
					Calendar calendar = new GregorianCalendar();
					calendar.setTime(rsReq.getDate("date"));
					Requerimiento reque = new Requerimiento(rsReq.getInt("id"), calendar,rsReq.getString("autorizaReq"), rsReq.getString("obserReq"), rsReq.getString("estadoReq").charAt(0));
					
					detReq.setRequerimiento(reque);		
			}*/
				list.add(detReq);
		}
		} catch (SQLException e) {
			System.err.println(">>>WARNING (JDBCDetRequerimientoDAO:find): " + e.getMessage());
		}
		return list;
	}

	@Override
	public Set<DetRequerimiento> finByRequerimientoID(Integer idRequerimiento) {
		Set<DetRequerimiento> list = new HashSet<DetRequerimiento>();
		ResultSet rsDetRequerimiento = jdbc2.query("SELECT * FROM DetRequerimiento WHERE iddetreq=" + idRequerimiento);
		try {
			while (rsDetRequerimiento.next()) {
				DetRequerimiento detReq = new DetRequerimiento(rsDetRequerimiento.getInt("IDDETREQ"), rsDetRequerimiento.getInt("CANTPRODETREQ"), rsDetRequerimiento.getInt("IDPRODDETREQ"),
						rsDetRequerimiento.getInt("INVENPRODDETREQ"), rsDetRequerimiento.getDouble("PRECPRODDETREQ"), rsDetRequerimiento.getInt("DESPRODDETREQ"));
				list.add(detReq);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCDetRequerimientoDAO:finByRequerimientoID): " + e.getMessage());
		}
		return list;
	}

	

}
