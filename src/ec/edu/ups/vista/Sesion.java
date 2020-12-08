package ec.edu.ups.vista;

import java.io.IOException;

import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ec.edu.ups.dao.DAOFactory;
import com.sun.security.auth.UnixNumericUserPrincipal;

import ec.edu.ups.dao.*;
import ec.edu.ups.modelo.*;


/**
 * Servlet implementation class Sesion
 */
@WebServlet("/Sesion")
public class Sesion extends HttpServlet  {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sesion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String usuario = request.getParameter("usuario");
		String contrasenia = request.getParameter("contrasena");
		//ArrayList<CatProductos> list = 
		
		Usuario usuarioObj = DAOFactory.getFactory().getUsuarioDAO().findUsuarioEmailPass(usuario, contrasenia);
		System.out.println(usuarioObj);

		

		
		if (usuarioObj != null) {			
			Empresa empresaObj = usuarioObj.getEmpresa();
			System.out.println("Estas la empresa "+empresaObj.getIdEmp());
			ArrayList<Productos> listPro = DAOFactory.getFactory().getProductosDAO().findbyEmpresaID(empresaObj.getIdEmp());
			//System.out.println("Estas loggeado");
			//<Requerimiento> lisRequerimientos = DAOFactory.getFactory().getRequerimientosDAO().findbyUserID(usuarioObj.getIdUsu());
			//usuarioObj.setRequerimientos(DAOFactory.getFactory().getRequerimientosDAO().findbyUserID(usuarioObj.getIdUsu()));
			ArrayList<CatProducto> categorias = DAOFactory.getFactory().getProductosDAO().findCatbyEmpresaID(usuarioObj.getEmpresa().getIdEmp());
			try {
				int idEmpresa = usuarioObj.getEmpresa().getIdEmp();
				//RequestDispatcher rd = null;
				//Establecer el inicio de sesion.
				HttpSession session = request.getSession(true);
				//Obtener datos del 
				String tipoUSU = String.valueOf(usuarioObj.getTipoUsu());	
				//System.out.println("El tipo de usuario es"+ tipoUSU);
				session.setAttribute("usr", usuarioObj);
				session.setAttribute("cat", categorias);
				session.setAttribute("listProS", listPro);
				//System.out.println("A verr");
				
				//ArrayList<Requerimiento> reque= (ArrayList<Requerimiento>) usuarioObj.getRequerimientos();
				if (tipoUSU.equals("A")) {
					//System.out.println("Has entrado como Admin");
					ArrayList<Requerimiento> reqListEmpresa = DAOFactory.getFactory().getRequerimientosDAO().finbyEmpresaID(idEmpresa);
					Set<DetRequerimiento> reqListDetReq = new HashSet<DetRequerimiento>();
					for(int i=0;i<reqListEmpresa.size();i++) {
						reqListDetReq= DAOFactory.getFactory().getDetRequerimientoDAO().finByRequerimientoID(reqListEmpresa.get(i).getIdReq());
						reqListEmpresa.get(i).setDetRequerimientos(reqListDetReq);
					}
					session.setAttribute("listReqEmp", reqListEmpresa);
					//System.out.println("RequerimientosEmpresa"+reqListEmpresa);
					request.getRequestDispatcher("/Admin/Administrador.jsp").forward(request,response);
						
					
				}else if(tipoUSU.equals("N")) {
					ArrayList<Requerimiento> requerimientoUsuario=DAOFactory.getFactory().getRequerimientosDAO().findbyUserID(usuarioObj.getIdUsu());
					Set<DetRequerimiento> detReqUsu = new HashSet<DetRequerimiento>();
					for(int i=0;i<requerimientoUsuario.size();i++) {
						detReqUsu= DAOFactory.getFactory().getDetRequerimientoDAO().finByRequerimientoID(requerimientoUsuario.get(i).getIdReq());
						requerimientoUsuario.get(i).setUsuario(usuarioObj);
						requerimientoUsuario.get(i).setDetRequerimientos(detReqUsu);;
					}
					session.setAttribute("listReqUsuario", requerimientoUsuario);
					request.getRequestDispatcher("/User/Usuario.jsp").forward(request,response);
					
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error: "+e);
			}
			
			/////////////////////////////////
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
