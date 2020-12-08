package ec.edu.ups.mysql.jdbc;

import ec.edu.ups.modelo.Empresa;
import ec.edu.ups.modelo.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresaDAO;
public class JDBCEmpresaDAO extends JDBCGenericDAO<Empresa, Integer> implements EmpresaDAO{

	@Override
	public void createTable() {
		jdbc1.update("DROP TABLE IF EXISTS Empresa");
		jdbc1.update("CREATE TABLE Empresa (" + "IDEMP INT AUTO_INCREMENT, " + "NOMEMP VARCHAR(255), "
				+ "DIREMP VARCHAR(255), " + "PRIMARY KEY (IDEMP))");
		//DAOFactory.getFactory().getUsuarioDAO().createTable();
		//DAOFactory.getFactory().getProductosDAO().createTable();
	}

	@Override
	public void create(Empresa empresa) {
		
		ResultSet rs = jdbc1.query("SELECT max(IDEMP) FROM Empresa ");
		try {
			if(rs.next()) {
				try {
					int id=(Integer)rs.getInt(1)+1;
					jdbc2.update("INSERT Empresa VALUES ("+id+" , '" + empresa.getNomEmp() + "', '"
							+ empresa.getDirEmp() + "')");
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
	public Empresa read(Integer id) {
		Empresa empresa = null;
		ResultSet rs = jdbc1.query("SELECT * FROM Empresa WHERE idemp=" + id);
		try {
			if (rs != null && rs.next()) {
				empresa = new Empresa(rs.getInt("idemp"), rs.getString("nomemp"), rs.getString("diremp"));
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCEmpresaDAO:read): " + e.getMessage());
		}

		return empresa;
	}

	@Override
	public void update(Empresa empresa) {
		jdbc1.update("UPDATE Empresa SET nomemp = '" + empresa.getNomEmp() + "', diremp = '"
				+ empresa.getDirEmp() + "' WHERE idEmp = " + empresa.getIdEmp());
		
	}

	@Override
	public void delete(Empresa empresa) {
		jdbc1.update("DELETE FROM Empresa WHERE idEmp = " + empresa.getIdEmp());
		
	}

	@Override
	public List<Empresa> find() {
		List<Empresa> list = new ArrayList<Empresa>();
		ResultSet rs = jdbc1.query("SELECT * FROM Empresa");
		try {
			while (rs.next()) {
				list.add(new Empresa(rs.getInt("idemp"), rs.getString("nomemp"), rs.getString("diremp")));
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCEmpresaDAO:find): " + e.getMessage());
		}
		return list;
	}

	

}
