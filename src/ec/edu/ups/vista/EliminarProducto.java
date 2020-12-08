package ec.edu.ups.vista;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.modelo.Empresa;
import ec.edu.ups.modelo.Productos;
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet implementation class EliminarProducto
 */
@WebServlet("/EliminarProducto")
public class EliminarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String n = request.getParameter("valorElim");
		System.out.println("La dimension es es" +n.length());
		String nn = n.substring(0,n.length()-2);
		int var=Integer.parseInt(nn);
		System.out.println("La variables es" +var);
		Productos prods= DAOFactory.getFactory().getProductosDAO().read(var); 
		System.out.println("En el principal"+prods);
		DAOFactory.getFactory().getProductosDAO().delete(prods);
		
		HttpSession session = request.getSession();
		Usuario usuarioObj = (Usuario)session.getAttribute("usr");
		Empresa empresaObj = usuarioObj.getEmpresa();
		
		ArrayList<Productos> listPro = DAOFactory.getFactory().getProductosDAO().findbyEmpresaID(empresaObj.getIdEmp());
		session.setAttribute("listProS", listPro);
		request.getRequestDispatcher("/Admin/EdiDelProductos.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
