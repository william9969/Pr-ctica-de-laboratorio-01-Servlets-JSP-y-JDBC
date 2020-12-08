<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="ec.edu.ups.modelo.Productos" %> 
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Administrar Productos</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/bootstrap.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/style.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/CSSADD.css"/>

</head>
<body>
	<header>
        <ul class="nav mt-2 justify-content-end">
            <li class="nav-item">
              <a class="nav-link active" href="<%=request.getContextPath()%>/Admin/Administrador.jsp">Inicio</a>
            </li>
            <li class="nav-item">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Productos</a>
              <div class="dropdown-menu">
                <a class="dropdown-item" href="<%=request.getContextPath()%>/Admin/RegistrarProducto.jsp">Agregar Productos</a>
                <a class="dropdown-item" href="<%=request.getContextPath()%>/Admin/EdiDelProductos.jsp">Editar Productos</a>
                <a class="dropdown-item" href="<%=request.getContextPath()%>/Admin/EdiDelProductos.jsp">Eliminar Productos</a>
                <a class="dropdown-item" href="#">Buscar Productos</a>
                <a class="dropdown-item" href="<%=request.getContextPath()%>/Admin/EdiDelProductos.jsp">Listar Productos</a>
              </div>
            </li>
            <li class="nav-item">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Requerimientos</a>
                <div class="dropdown-menu">
                  <a class="dropdown-item" href="<%=request.getContextPath()%>/Admin/ListarRequerimientos.jsp">Aprobar Requerimientos</a>
           
                  <a class="dropdown-item" href="<%=request.getContextPath()%>/Admin/ListarRequerimientos.jsp">Listar Requerimientos</a>
                </div>
            </li>
            <li class="nav-item">
            	 <form action="http://localhost:8080/Practica01/LogOut" method="get">
	             		 <button type="submit" class="nav-link btn-danger">Salir</button>
	             	</form>
            </li>
           
          </ul>
    </header>
    
<!--
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        ...
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary">Save changes</button>
	      </div>
	    </div>
	  </div>
	</div>
    
	-->
	<div class="card text-center">
        <div class="card-header  bg-dark"> </div>
      </div>
	<% HttpSession sesion=request.getSession(); %>
	<% Productos product = new Productos(); %> 
	<% ArrayList<Productos> list= new ArrayList<Productos>();  %> 
	<% list = (ArrayList<Productos>)sesion.getAttribute("listProS"); %>
	<% sesion.setAttribute("usrEPAd", null);%>
	<div class="container-md">
		<table class="table">
			  <thead class="thead-dark">
			    <tr>
			      <th scope="col">ID</th>
			      <th scope="col">Nombre</th>
			      <th scope="col">Precio</th>
			      <th scope="col">Opcion</th>
			    </tr>
			  </thead>
			  <tbody class="bg-light">
				  <% for(int i = 0; i < list.size(); i++) {%>
		           	  
					<% product = list.get(i); %>
					<tr>
		               <th scope="row"><%out.println(product.getIdProd());%></th>
		               <td ><%out.println(product.getNomProd());%></td>
		               <td><%out.println(product.getPrecProd());%></td>
		               <td class="">
                            <form action="http://localhost:8080/Practica01/EditarProducto" method="get"> 
                            	<button type="submit" class="btn btn-outline-secondary btn-sm btn-block"  name="valorEdit" value="<%out.println(product.getIdProd());%>">Editar</button>
                            </form>
                            <form action="http://localhost:8080/Practica01/EliminarProducto" method="get"> 
                            	<button type="submit" class="btn btn-outline-dark btn-sm btn-block"  name="valorElim" value="<%out.println(product.getIdProd());%>">Eliminar</button>
                            </form>
                            </td>
		          		</tr>
		           <% } %>
			  </tbody>
		</table>
	      
	</div>
	
	<br>
	<br>
	<footer class="footer-box">
        <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="full">
                    <div class="heading_main text_align_center white_fonts margin-bottom_30">
                    <h2>Contactanos</h2>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            
            <div class="col-lg-3 col-md-6 col-sm-6 white_fonts">
                <div class="full footer_blog f_icon_1">
                    <p>Dirección<br><small>Av. Americas y Av.Don Bosco,<br>Redondel 12 de Ocutubre,<br>Av. Americas </small></p>
                </div>
            </div>

            <div class="col-lg-3 col-md-6 col-sm-6 white_fonts">
                <div class="full footer_blog f_icon_2">
                    <p>Phone<br><small>+84 126 922 0162<br>+84 905 333 333<br>Lunes - Domingo<br>08:00 am - 05:00 pm</small></p>
                </div>
            </div>

            <div class="col-lg-3 col-md-6 col-sm-6 white_fonts">
                <div class="full footer_blog f_icon_3">
                    <p>Email<br><small>wsinchi@est.ups.edu.ec<br>gjessica@est.ups.edu.ec</small></p>
                </div>
            </div>

            <div class="col-lg-3 col-md-6 col-sm-6 white_fonts">
                <div class="full footer_blog_last">
                    <p>Social media</p>
                    <p>
                    <ul>
                        <li><a href="#"><i class="fa fa-facebook-f"></i></a></li>
                        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                        <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                        <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                        <li><a href="#"><i class="fa fa-youtube"></i></a></li>
                    </ul>
                    </p>
                </div>
            </div>
        
        </div>
        </div>
    </footer>
 <!-- End Footer -->
    <div class="footer_bottom">
        <div class="container">
        <div class="row">
            <div class="col-12">
                <p class="crp">© Copyrights 2020 diseñado por <a href="" title="Free Website Templates">William&Jessica</a></p>
            </div>
        </div>
        </div>
    </div>
    
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script> 
	
</body>
</html>