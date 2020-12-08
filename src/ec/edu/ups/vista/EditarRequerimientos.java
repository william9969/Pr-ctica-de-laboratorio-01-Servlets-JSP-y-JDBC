package ec.edu.ups.vista;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.modelo.DetRequerimiento;
import ec.edu.ups.modelo.Productos;
import ec.edu.ups.modelo.Requerimiento;
import ec.edu.ups.modelo.Usuario;
/**
 * Servlet implementation class EditarRequerimientos
 */
@WebServlet("/EditarRequerimientos")
public class EditarRequerimientos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarRequerimientos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Requerimiento reqEdit = (Requerimiento)session.getAttribute("requerEmpEditar");
		Usuario usu = (Usuario)session.getAttribute("usr");
		
		if(reqEdit!=null) {
			
			int idEmpresa = usu.getEmpresa().getIdEmp();
			
			String value=request.getParameter("name");
			System.out.println("Imprimit valor de selecion");

			String estado=request.getParameter("estado");
			String obsReq=request.getParameter("obsRequerimiento");
			String fecR=request.getParameter("fechaReq");
			
			Requerimiento reqnuevo = new Requerimiento(reqEdit.getIdReq(),reqEdit.getFecReq(),usu.getNombreUsu(),obsReq,estado.charAt(0));
			reqnuevo.setDetRequerimientos(reqEdit.getDetRequerimientos());
			reqnuevo.setUsuario(reqEdit.getUsuario());
			DAOFactory.getFactory().getRequerimientosDAO().update(reqnuevo);
			System.out.println("Requerimiento nuevo" + reqnuevo);
			
			ArrayList<Requerimiento> reqListEmpresa = DAOFactory.getFactory().getRequerimientosDAO().finbyEmpresaID(idEmpresa);
			Set<DetRequerimiento> reqListDetReq = new HashSet<DetRequerimiento>();
			for(int i=0;i<reqListEmpresa.size();i++) {
				reqListDetReq= DAOFactory.getFactory().getDetRequerimientoDAO().finByRequerimientoID(reqListEmpresa.get(i).getIdReq());
				reqListEmpresa.get(i).setDetRequerimientos(reqListDetReq);
			}
			session.setAttribute("listReqEmp", reqListEmpresa);
			Requerimiento req=null;
			session.setAttribute("requerEmpEditar", req);
			//System.out.println("RequerimientosEmpresa"+reqListEmpresa);
			request.getRequestDispatcher("/Admin/ListarRequerimientos.jsp").forward(request,response);
			
		}
		else if(reqEdit==null) {
			String idid = request.getParameter("idRequerimientoEditar");
			String idRequerimientoEdit = idid.substring(0,idid.length()-2);
			int idReq= Integer.parseInt(idRequerimientoEdit);	
			Requerimiento requerimiento= DAOFactory.getFactory().getRequerimientosDAO().read(idReq);
			System.out.println(requerimiento);
			Set<DetRequerimiento> detReqUsu = new HashSet<DetRequerimiento>();
			
			if(requerimiento!=null) {
				detReqUsu= DAOFactory.getFactory().getDetRequerimientoDAO().finByRequerimientoID(requerimiento.getIdReq());
				requerimiento.setDetRequerimientos(detReqUsu);
			}
			session.setAttribute("requerEmpEditar", requerimiento);
			request.getRequestDispatcher("/Admin/AdministrarRequerimientos.jsp").forward(request,response);
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
