package ec.edu.ups.vista;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.modelo.Productos;
import ec.edu.ups.mysql.jdbc.JDBCProductosDAO;
/**
 * Servlet implementation class busquedaMPZ
 */
@WebServlet("/busquedaMPZ")
public class busquedaMPZ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public busquedaMPZ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idEmpresa= 1;
		ArrayList<Productos> productos =  DAOFactory.getFactory().getProductosDAO().findbyEmpresaID(idEmpresa);
		//System.out.println(productos);
		request.setAttribute("productos", productos); 
		request.getRequestDispatcher("/LisProductos.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
