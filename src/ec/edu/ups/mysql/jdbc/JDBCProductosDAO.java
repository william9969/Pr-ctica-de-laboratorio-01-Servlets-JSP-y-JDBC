package ec.edu.ups.mysql.jdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import ec.edu.ups.modelo.Empresa;
import ec.edu.ups.modelo.CatProducto;
import ec.edu.ups.dao.ProductosDAO;
import ec.edu.ups.modelo.Productos;
import ec.edu.ups.modelo.Usuario;
public class JDBCProductosDAO extends JDBCGenericDAO<Productos, Integer> implements ProductosDAO{

	@Override
	public void createTable() {
		jdbc2.update("DROP TABLE IF EXISTS Producto");
		jdbc2.update("CREATE TABLE Producto (" + "IDPROD INT AUTO_INCREMENT, " + "NOMPROD VARCHAR(255), "
				+ "PRECPROD DECIMAL(4,2), CANTPROD INT, IDEMPPROD INT, " + "IDPRODCATPROD INT, " + "PRIMARY KEY (IDPROD),"
						+ "FOREIGN KEY(IDEMPPROD) REFERENCES Empresa(IDEMP), FOREIGN KEY(IDPRODCATPROD) REFERENCES CatProducto(IDCATPROD))");
		
	}

	@Override
	public void create(Productos producto) {
		ResultSet rs = jdbc1.query("SELECT max(IDPROD) FROM Producto ");
		try {
			if(rs.next()) {
				try {
					int id=(Integer)rs.getInt(1)+1;
					jdbc2.update("INSERT Producto VALUES ("+id+",'"+producto.getNomProd()+"', "+producto.getPrecProd()+" , "+producto.getCantProd()+" , "+
							producto.getEmpresa().getIdEmp()+" , "+producto.getCatProd().getIdCatProd()+ ")");
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
	public Productos read(Integer id) {
		Productos producto = null;
		ResultSet rsProducto = jdbc1.query("SELECT * FROM Producto WHERE idprod=" + id);
		try {
			if (rsProducto != null && rsProducto.next()) {
				producto = new Productos(rsProducto.getInt("idprod"),rsProducto.getString("nomprod"),rsProducto.getDouble("precprod"),rsProducto.getInt("cantprod"));
				/*ResultSet rsEmpresa = jdbc2
						.query(("SELECT * FROM Empresa WHERE idemp=" + rsProducto.getInt("idempprod")));

				if (rsEmpresa != null && rsEmpresa.next()) {
					Empresa empresa = new Empresa(rsEmpresa.getInt("idemp"), rsEmpresa.getString("nomemp"), rsEmpresa.getString("diremp"));
					producto.setEmpresa(empresa);
				}*/
				
				ResultSet rsCatProducto = jdbc2
						.query(("SELECT * FROM CatProducto WHERE idcatprod=" + rsProducto.getInt("idprodcatprod")));
				if (rsCatProducto != null && rsCatProducto.next()) {
					CatProducto catProducto = new CatProducto(rsCatProducto.getInt("idcatprod"), rsCatProducto.getString("nomcatprod"));
					producto.setCatProd(catProducto);;
				}

			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCProductDAO:read): " + e.getMessage());
		}
		if (producto == null) {
			return null;
		}
		return producto;
	}

	@Override
	public void update(Productos producto) {
		jdbc1.update("UPDATE Producto SET nomprod = ' "+ producto.getNomProd() +" ' , precprod = "+producto.getPrecProd()+", cantprod = "+ producto.getCantProd()+
				" WHERE idprod = "+producto.getIdProd());
		
	}

	@Override
	public void delete(Productos producto) {
		jdbc1.update("DELETE FROM Producto WHERE idprod = " + producto.getIdProd());
		
	}

	@Override
	public List<Productos> find() {
		List<Productos> list = new ArrayList<Productos>();
		ResultSet rsProducto = jdbc1.query("SELECT * FROM Producto");
		try {
			while (rsProducto.next()) {
				Productos producto = new Productos(rsProducto.getInt("idprod"),rsProducto.getString("nomprod"),rsProducto.getDouble("precprod"),rsProducto.getInt("cantprod"));
				/*ResultSet rsEmpresa = jdbc2
						.query(("SELECT * FROM Empresa WHERE idemp=" + rsProducto.getInt("idempprod")));

				if (rsEmpresa != null && rsEmpresa.next()) {
					Empresa empresa = new Empresa(rsEmpresa.getInt("idemp"), rsEmpresa.getString("nomemp"), rsEmpresa.getString("diremp"));
					producto.setEmpresa(empresa);
				}*/
				
				ResultSet rsCatProducto = jdbc2
						.query(("SELECT * FROM CatProducto WHERE idcatprod=" + rsProducto.getInt("idprodcatprod")));
				if (rsCatProducto != null && rsCatProducto.next()) {
					CatProducto catProducto = new CatProducto(rsCatProducto.getInt("idcatprod"), rsCatProducto.getString("nomcatprod"));
					producto.setCatProd(catProducto);;
				}
				list.add(producto);
				
			}
			
		}catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCProductDAO:find): " + e.getMessage());
		}

		return list;
	}

	@Override
	public Set<Productos> findbyCatProductosID(Integer catProdId) {
		Set<Productos> list = new HashSet<Productos>();
		ResultSet rsProducto = jdbc2.query("SELECT * FROM Producto WHERE idcatprod=" + catProdId);
		try {
			while (rsProducto.next()) {
				Productos producto = new Productos(rsProducto.getInt("idprod"),rsProducto.getString("nomprod"),rsProducto.getDouble("precprod"),rsProducto.getInt("cantprod"));
				list.add(producto);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCProductoDAO:findByCatProoductosID): " + e.getMessage());
		}

		return list;
		
	}

	@Override
	public ArrayList<Productos> findbyEmpresaID(Integer empresaId) {
		ArrayList<Productos> list = new ArrayList<Productos>();
		ResultSet rsProducto = jdbc2.query("SELECT * FROM Producto WHERE IDEMPPROD=" + empresaId);
		try {
			while (rsProducto.next()) {
				Productos producto = new Productos(rsProducto.getInt("idprod"),rsProducto.getString("nomprod"),rsProducto.getDouble("precprod"),rsProducto.getInt("cantprod"));
				list.add(producto);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCProductoDAO:findbyEmpresaID): " + e.getMessage());
		}

		return list;
	}

	@Override
	public ArrayList<CatProducto> findCatbyEmpresaID(Integer empresa) {
		ArrayList<CatProducto> categorias = new ArrayList<CatProducto>();
		
		ResultSet rsCategorias = jdbc1.query("SELECT  * FROM catproducto as cp, producto as p where p.idempprod="+empresa+" and p.IDPRODCATPROD =cp.IDCATPROD  GROUP BY cp.idcatprod, p.IDPRODCATPROD");
		try {
			while (rsCategorias.next()) {
				CatProducto cat = new CatProducto(rsCategorias.getInt("IDCATPROD"),rsCategorias.getString("NOMCATPROD"));
 				categorias.add(cat);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCProductoDAO:findCatbyEmpresaID): " + e.getMessage());
		}
		return categorias;
	}

}
