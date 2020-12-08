package ec.edu.ups.vista;

import java.io.IOException;
import ec.edu.ups.dao.DAOFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.modelo.CatProducto;
import ec.edu.ups.modelo.Empresa;
import ec.edu.ups.modelo.Productos;
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet implementation class RegistrarProducto
 */
@WebServlet("/RegistrarProducto")
public class RegistrarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession sesion=request.getSession();
		 Productos prodRP= new Productos(0,request.getParameter("nomProdR"),Double.parseDouble(request.getParameter("precProR")),Integer.parseInt(request.getParameter("canProR")));
		 System.out.println("producyo normal" + prodRP);
		 Usuario usuRP = (Usuario)sesion.getAttribute("usr");
		 Empresa empRP = DAOFactory.getFactory().getEmpresaDAO().read(usuRP.getEmpresa().getIdEmp());
		 System.out.println("Empresa"+empRP);
		 CatProducto catprRP = DAOFactory.getFactory().getCatProductoDAO().read(Integer.parseInt(request.getParameter("catProR")));
		 
		 prodRP.setEmpresa(empRP);
		 prodRP.setCatProd(catprRP);
		 
		 try {
			 DAOFactory.getFactory().getProductosDAO().create(prodRP);
			 System.out.println("Producto total" + prodRP);
			 request.getRequestDispatcher("/Admin/RegistrarProducto.jsp").forward(request,response);
			 
		 }catch(Exception e) {
				System.out.println("Problema para agregar el producto" + e.getMessage());
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
