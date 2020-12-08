package ec.edu.ups.mysql.jdbc;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.modelo.DetRequerimiento;
import ec.edu.ups.modelo.Empresa;
import ec.edu.ups.modelo.Requerimiento;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UsuarioDAO;

public class JDBCUsuarioDAO extends JDBCGenericDAO<Usuario, Integer> implements UsuarioDAO{

	@Override
	public void createTable() {
		jdbc2.update("DROP TABLE IF EXISTS Usuario");
		jdbc2.update("CREATE TABLE Usuario (" + "IDUSU INT AUTO_INCREMENT, " + "NOMBREUSU VARCHAR(255), "
				+ "EMAILUSU VARCHAR(255), PASSUSU VARCHAR(255), TIPOUSU CHAR(1), " + "IDEMPUSU INT NOT NULL," + "PRIMARY KEY (IDUSU),"
						+ "FOREIGN KEY(IDEMPUSU) REFERENCES Empresa(IDEMP))");
		
	}

	@Override
	public void create(Usuario usuario) {
		
		ResultSet rs = jdbc1.query("SELECT max(IDUSU) FROM Usuario ");
		try {
			if(rs.next()) {
				try {
					int id=(Integer)rs.getInt(1)+1;
					jdbc2.update("INSERT Usuario VALUES ("+id+",'"+ usuario.getNombreUsu() + "' , '"
							+ usuario.getEmailUsu() + "','" + usuario.getPassUsu()+"' , '"+usuario.getTipoUsu()+"', " + usuario.getEmpresa().getIdEmp() + ")");
					System.out.println("Producto Agregado");
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
	public Usuario read(Integer id) {
		Usuario usuario = null;
		ResultSet rsUsuario = jdbc1.query("SELECT * FROM Usuario WHERE idusu=" + id);
		try {
			if (rsUsuario != null && rsUsuario.next()) {
				usuario = new Usuario(rsUsuario.getInt("idusu"),rsUsuario.getString("nombreusu"),rsUsuario.getString("emailusu"),rsUsuario.getString("passusu"),rsUsuario.getString("TIPOUSU").charAt(0));
				
				/*ResultSet rsEmpresa = jdbc2
						.query("SELECT * FROM Empresa WHERE idemp=" + rsUsuario.getInt("idempusu"));

				if (rsEmpresa != null && rsEmpresa.next()) {
					Empresa empresa = new Empresa(rsEmpresa.getInt("idemp"), rsEmpresa.getString("nomemp"), rsEmpresa.getString("diremp"));
					usuario.setEmpresa(empresa);
				}*/

			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUsuarioDAO:read): " + e.getMessage());
		}
		if (usuario == null) {
			return null;
		}
		ArrayList<Requerimiento> requerimientos = DAOFactory.getFactory().getRequerimientosDAO().findbyUserID(usuario.getIdUsu());//getProductDAO().findByShoppingBasketId(shoppingBasket.getId());
		if (requerimientos != null) {
			Set<Requerimiento> requerimientosFinal = new HashSet<Requerimiento>();
			for (Requerimiento reqs : requerimientos) {
				reqs.setUsuario(usuario);
				requerimientosFinal.add(reqs);
			}
			usuario.setRequerimientos(requerimientosFinal);
		}
		
		return usuario;
		
	}

	@Override
	public void update(Usuario usuario) {
		jdbc1.update("UPDATE Usuario SET nombreusu = ' " +usuario.getNombreUsu() + " ', emailusu = ' "+ usuario.getEmailUsu()  
				+" ', passusu = ' "+usuario.getPassUsu()  +" ', tipousu = ' " + usuario.getTipoUsu() +"' WHERE idusu = " + usuario.getIdUsu());
		
	}

	@Override
	public void delete(Usuario usuario) {
		
		if (usuario.getRequerimientos() != null ) {
			for (Requerimiento reque : usuario.getRequerimientos()) {
				DAOFactory.getFactory().getRequerimientosDAO().delete(reque);
			}
		}
		
		jdbc1.update("DELETE FROM Usuario WHERE idusu = " + usuario.getIdUsu());
		
	}

	@Override
	public List<Usuario> find() {
		
		List<Usuario> list = new ArrayList<Usuario>();
		ResultSet rsUsuario = jdbc1.query("SELECT * FROM Usuario");
		try {
			while (rsUsuario.next()) {
				Usuario usuario = new Usuario(rsUsuario.getInt("idUsu"),rsUsuario.getString("nombreusu"),rsUsuario.getString("emailusu"),rsUsuario.getString("passusu"),rsUsuario.getString("TIPOUSU").charAt(0));
				//ResultSet rsEmpresa = jdbc2.query("SELECT * FROM Empresa WHERE idemp=" + + rsUsuario.getInt("idempusu"));
				list.add(usuario);
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUsuarioDAO:find): " + e.getMessage());
		}

		return list;
		
	}

	@Override
	public Set<Usuario> findByEmpresaID(Integer idEmp) {
		
		Set<Usuario> list = new HashSet<Usuario>();
		ResultSet rsUsuario = jdbc2.query("SELECT * FROM Usuario WHERE idempusu=" + idEmp);
		try {
			while (rsUsuario.next()) {
				Usuario usuario = new Usuario(rsUsuario.getInt("idUsu"),rsUsuario.getString("nombreusu"),rsUsuario.getString("emailusu"),rsUsuario.getString("passusu"),rsUsuario.getString("TIPOUSU").charAt(0));
				list.add(usuario);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCUsuarioDAO:findByEmpresaID): " + e.getMessage());
		}

		return list;
		
		
	}

	@Override
	public Usuario findUsuarioEmailPass(String emailUsuario, String passUsuario) {
		// TODO Auto-generated method stub
		Usuario usuario = null;
		Empresa empresa = null;
		ResultSet rsUsuario = jdbc1.query("SELECT * FROM Usuario WHERE EMAILUSU='" + emailUsuario+"' AND PASSUSU='"+passUsuario+"'");
		try {
			if (rsUsuario != null && rsUsuario.next()) {
				usuario = new Usuario(rsUsuario.getInt("idusu"),rsUsuario.getString("nombreusu"),rsUsuario.getString("emailusu"),rsUsuario.getString("passusu"),rsUsuario.getString("TIPOUSU").charAt(0));
				ResultSet rsEmpresa = jdbc2.query("SELECT * FROM Empresa WHERE idemp="+ rsUsuario.getInt("IDEMPUSU"));
				if (rsEmpresa != null && rsEmpresa.next()) {
					empresa = new Empresa(rsEmpresa.getInt("idemp"), rsEmpresa.getString("nomemp"), rsEmpresa.getString("diremp"));
					//System.out.println("Id de la Empresa en el Usuario"+rsUsuario.getInt("IDEMPUSU"));
					//System.out.println("La empresa es"+empresa);
					usuario.setEmpresa(empresa);
				}
				
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCfindUsuarioEmailPass:Session): " + e.getMessage());
		}		
		if(usuario == null)
			return null;
			
		return usuario;
	}
/*
	@Override
	public Empresa findEmpresaByUserId(Integer userID) {
		Empresa empresa = null;
		ResultSet rsEmpresa = jdbc1.query("SELECT * FROM Empresa WHERE idemp="+ userID);
		try {
			if (rsEmpresa != null && rsEmpresa.next()) {
				empresa = new Empresa(rsEmpresa.getInt(""), rsEmpresa.getString(""), rsEmpresa.getString(""));
				
			}
			}catch (SQLException e) {
				System.out.println(">>>WARNING (JDBCfindUsuarioEmailPass:Session): " + e.getMessage());
			}
		
		
		return empresa;
	}
*/
	

}
