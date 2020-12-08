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
 * Servlet implementation class EditarProducto
 */
@WebServlet("/EditarProducto")
public class EditarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		Productos prods = (Productos)session.getAttribute("usrEPAd");
		Usuario usuProEDI = (Usuario)session.getAttribute("usr");
		Empresa empEditPRod = DAOFactory.getFactory().getEmpresaDAO().read(usuProEDI.getEmpresa().getIdEmp());
		if(prods!=null) {
			String nombre = request.getParameter("nomProdEditar");
			String precio = request.getParameter("precProdEditar");
			String cantidad = request.getParameter("canProdEditar");
			
			
			Productos editarProducto = new Productos(prods.getIdProd(), nombre, Double.parseDouble(precio), Integer.parseInt(cantidad));
			editarProducto.setEmpresa(empEditPRod);
			editarProducto.setCatProd(prods.getCatProd());
			
			
			System.out.println("PRODUCTO Nuevo A EDITAR"+editarProducto);
			DAOFactory.getFactory().getProductosDAO().update(editarProducto);
			
			ArrayList<Productos> listPro = DAOFactory.getFactory().getProductosDAO().findbyEmpresaID(empEditPRod.getIdEmp());
			session.setAttribute("listProS", listPro);
			session.setAttribute("usrEPAd", null);
			request.getRequestDispatcher("/Admin/EdiDelProductos.jsp").forward(request,response);
			
		}else if(prods==null) {
			String n = request.getParameter("valorEdit");
			//System.out.println("El valor es    " +n);
			String nn = n.substring(0,n.length()-2);
			int var=Integer.parseInt(nn);
			 prods = DAOFactory.getFactory().getProductosDAO().read(var);
			 
			 prods.setEmpresa(empEditPRod);
			 
			 System.out.println("Producto a Editar" + prods);
			session.setAttribute("usrEPAd", prods);
			request.getRequestDispatcher("/Admin/EditarProductos.jsp").forward(request,response);
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
