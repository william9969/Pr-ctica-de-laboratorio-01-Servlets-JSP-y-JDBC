package ec.edu.ups.vista;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.text.*;

import ec.edu.ups.modelo.Requerimiento;
import ec.edu.ups.mysql.jdbc.JDBCDetRequerimientoDAO;
import ec.edu.ups.mysql.jdbc.JDBCRequerimientosDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.modelo.*;

/**
 * Servlet implementation class Requerimiento
 */
@WebServlet("/RequerimientoC")
public class RequerimientoC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
   

    protected void processRequest (HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException
    {
    	HttpSession session = request.getSession();
		System.out.println("Entro");
		Usuario usr = new Usuario();
		usr = (Usuario)session.getAttribute("usr");
		
    	System.out.println("Crear objeto");
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	Productos producto;
    	DetRequerimiento detRequerimiento;
    	Requerimiento requerimiento;

    	
    	int cantidadFactura = Integer.parseInt(request.getParameter("cantidadFactura"));
    	
    	Double total =0.0;
    	
    	
		
		Usuario usuReq = DAOFactory.getFactory().getUsuarioDAO().read(usr.getIdUsu());
		
		GregorianCalendar gcalendario = new GregorianCalendar();
		requerimiento = new Requerimiento(0, gcalendario.getInstance(), "", "",'P');
		System.out.println(requerimiento);
		requerimiento.setUsuario(usuReq);
		DAOFactory.getFactory().getRequerimientosDAO().create(requerimiento);
		
		//System.out.println("ID:"+requerimiento.getIdReq());
		int idReq = DAOFactory.getFactory().getRequerimientosDAO().ultimoReqCreado();
		
    	for (int i = 1; i <= cantidadFactura; i++) {
    		String nombre = request.getParameter("prod"+i);
    		
    		Double precio = Double.parseDouble(request.getParameter("precio"+i));
    		System.out.println(nombre);
    		int cantidad = Integer.parseInt(request.getParameter("cantidad"+i));
    		//Productos cantidad = DAOFactory.getFactory().getProductosDAO().read());
    		int idproducto = Integer.parseInt(request.getParameter("id"+i));
    		//Productos idproducto = DAOFactory.getFactory().getProductosDAO().read(Integer.parseInt(request.getParameter("id"+i)));
    		int descuento = Integer.parseInt(request.getParameter("descuento"+i));
    		
    		//producto = new Productos(idproducto, nombre, precio, cantidad);
    		producto = DAOFactory.getFactory().getProductosDAO().read(idproducto);
    		System.out.println(producto);
    		//Productos productoId = DAOFactory.getFactory().getProductosDAO().read(id)
    	
    		detRequerimiento= new DetRequerimiento(0, cantidad, idproducto, producto.getCantProd(), producto.getPrecProd(), descuento);
    		
    		
    		//total += cantidad * precio;
    		
    		detRequerimiento.setRequerimiento(DAOFactory.getFactory().getRequerimientosDAO().read(idReq));
    		
    		DAOFactory.getFactory().getDetRequerimientoDAO().create(detRequerimiento);
    		
    	}
    	response.getWriter().print("La compra ha sida registrado correctamente");
    	request.getRequestDispatcher("/User/Requerimiento.jsp").forward(request,response);
    }    
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		processRequest(request, response);
		
		/*
		HttpSession session = request.getSession();
		System.out.println("Entro");
		Usuario usr = new Usuario();
		usr = (Usuario)session.getAttribute("usr");
		
		ArrayList<Productos> lista = new ArrayList<Productos>();
		
		lista = (ArrayList<Productos>)session.getAttribute("listProS");
		
		try
        {
			String dataEmTexto = request.getParameter("fecha");
			Calendar data = null;
			java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dataEmTexto);
			data = Calendar.getInstance();
			data.setTime(date);
			Requerimiento requerimiento = new Requerimiento(0, data , "" , "" ,'P');
			DetRequerimiento detReq = new DetRequerimiento(0, Integer.parseInt(request.getParameter("canticompra")), Integer.parseInt(request.getParameter("idProd")),0 , Double.parseDouble(request.getParameter("precompra")), Integer.parseInt(request.getParameter("descuento")));
			DAOFactory.getFactory().getRequerimientosDAO().create(requerimiento);
			DAOFactory.getFactory().getDetRequerimientoDAO().create(detReq);
        }
       
		 catch(ParseException a)
        {
	         System.out.println(" Error de índice en un array");
        }
		*/
	}

}
