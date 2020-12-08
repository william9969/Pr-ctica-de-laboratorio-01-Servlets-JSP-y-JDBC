package ec.edu.ups.mysql.jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.modelo.Productos;
import ec.edu.ups.modelo.CatProducto;
import ec.edu.ups.dao.CatProductoDAO;
public class JDBCCatProductoDAO extends JDBCGenericDAO<CatProducto, Integer> implements CatProductoDAO{

	@Override
	public void createTable() {
		jdbc1.update("DROP TABLE IF EXISTS CatProducto");
		jdbc1.update("CREATE TABLE CatProducto (" + "IDCATPROD INT AUTO_INCREMENT, " + "NOMCATPROD VARCHAR(255), " + "PRIMARY KEY (IDCATPROD))");
	}

	@Override
	public void create(CatProducto catProducto) {
		
		ResultSet rs = jdbc1.query("SELECT max(IDCATPROD) FROM CatProducto ");
		try {
			if(rs.next()) {
				try {
					int id=(Integer)rs.getInt(1)+1;
					jdbc2.update("INSERT CatProducto VALUES ("+id+" , '" + catProducto.getNomCatProd() +"')");
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
	public CatProducto read(Integer id) {
		/*CatProducto catProducto = null;
		ResultSet rs = jdbc1.query("SELECT * FROM CatProducto WHERE idcatprod=" + id);
		try {
			if (rs != null && rs.next()) {
				catProducto = new CatProducto(rs.getInt("idcatprod"), rs.getString("nomcatprod"));
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCCatProductoDAO:read): " + e.getMessage());
		}

		return catProducto;
		
		*/
		CatProducto catProducto = null;
		ResultSet rs = jdbc1.query("SELECT * FROM CatProducto WHERE idcatprod=" + id);
		try {
			if (rs != null && rs.next()) {
				
				catProducto = new CatProducto(rs.getInt("idcatprod"), rs.getString("nomcatprod"));
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCCatProductoDAO:read): " + e.getMessage());
		}
		if (catProducto == null) {
			return null;
		}
		

		return catProducto;
		
		
		
	}

	@Override
	public void update(CatProducto catProducto) {
		jdbc1.update("UPDATE CatProducto SET nomcatprod = '" + catProducto.getNomCatProd() + "' WHERE idcatprod = " + catProducto.getIdCatProd());
		
	}

	@Override
	public void delete(CatProducto catProducto) {
		jdbc1.update("DELETE FROM CatProducto WHERE idcatprod = " + catProducto.getIdCatProd());
		
	}

	@Override
	public List<CatProducto> find() {
		List<CatProducto> list = new ArrayList<CatProducto>();
		ResultSet rs = jdbc1.query("SELECT * FROM Category");
		try {
			while (rs.next()) {
				list.add(new CatProducto(rs.getInt("idcatprod"), rs.getString("nomcatprod")));
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCCatProductoDAO:find): " + e.getMessage());
		}
		return list;
	}

	
}
