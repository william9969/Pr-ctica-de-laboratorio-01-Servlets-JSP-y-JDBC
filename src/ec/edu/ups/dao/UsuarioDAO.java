package ec.edu.ups.dao;
import java.util.Set;

import ec.edu.ups.modelo.Empresa;
import ec.edu.ups.modelo.Usuario;
public interface UsuarioDAO extends GenericDAO<Usuario, Integer>{
	public abstract Set<Usuario> findByEmpresaID(Integer empresaID);
	public abstract Usuario findUsuarioEmailPass(String emailUsuario, String passUsuario);
	//public abstract Empresa findEmpresaByUserId(Integer userID);
	
}
