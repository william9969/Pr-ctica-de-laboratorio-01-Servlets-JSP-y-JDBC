package ec.edu.ups.dao;
import java.util.ArrayList;
import ec.edu.ups.modelo.CatProducto;
import java.util.Set;

import ec.edu.ups.modelo.Productos;

public interface ProductosDAO extends GenericDAO<Productos, Integer>{
	public abstract Set<Productos> findbyCatProductosID(Integer catProdId);
	public abstract ArrayList<Productos> findbyEmpresaID(Integer empresaId);
	public abstract ArrayList<CatProducto> findCatbyEmpresaID(Integer empresa);
	
}
