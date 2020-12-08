<%@page import="java.util.HashSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ec.edu.ups.modelo.Requerimiento" %>
<%@ page import="ec.edu.ups.modelo.DetRequerimiento" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Listar Requerimientos</title>
	<link rel="stylesheet" type='text/css' href="<%=request.getContextPath()%>/CSS/bootstrap-grid.css" />     
	<link rel="stylesheet" type='text/css' href="<%=request.getContextPath()%>/CSS/bootstrap.css"/>
	<link rel="stylesheet" type='text/css' href="<%=request.getContextPath()%>/CSS/style.css"/>
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
    <div class="card text-center">
        <div class="card-header  bg-dark"> </div>
      </div>
    <div class="section about_section layout_padding dash_bg">

    
    <div class="container-md">
    	<% HttpSession sesion=request.getSession(); %>
    	<% Requerimiento requerimiento = new Requerimiento(); %> 
		<% ArrayList<Requerimiento> listRequerimientos= new ArrayList<Requerimiento>();  %> 
		<% Set<DetRequerimiento> listDetRequerimientos= new HashSet<DetRequerimiento>(); %>
		<% listRequerimientos = (ArrayList<Requerimiento>)sesion.getAttribute("listReqEmp"); %>
    
    	<% for(int i = 0; i < listRequerimientos.size(); i++) {%>
			<% requerimiento = listRequerimientos.get(i); %>
	    	<div class="card">
				  <div class="card-header">
				    Requerimiento N° <%out.println(i+1);%>
				  </div>
				  <div class="card-body">
				    <p class="card-text">ID Requerimiento: <%out.println(requerimiento.getIdReq());%></p>
				    <p class="card-text">Nombre del Solicitante: <%out.println(requerimiento.getUsuario().getNombreUsu());%></p>
				    <p class="card-text">Autorizado Por: <%out.println(requerimiento.getAutorizaReq());%></p>
				    <p class="card-text">Observacion del Requerimiento: <%out.println(requerimiento.getObserReq());%></p>
				    <p class="card-text">Estado del Requerimiento: <%out.println(requerimiento.getEstadoReq());%></p>
				    <p>
					  <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample<%out.println(i);%>" role="button" aria-expanded="false" aria-controls="collapseExample">
					    Mostrar Detalle
					  </a>
					  <form action="http://localhost:8080/Practica01/EditarRequerimientos" method="get">
                      		<button type="submit" class="btn btn-primary"  name="idRequerimientoEditar" value="<%out.println(requerimiento.getIdReq());%>">Editar Requerimiento</button>
                      </form>
					</p>
		  		</div>
		  		
		  		<div class="collapse" id="collapseExample<%out.println(i);%>">
					  <div class="card card-body">
					  <table class="table">
						  <thead class="thead-dark">
						    <tr>
						      <th scope="col">ID</th>
						      <th scope="col">Cantidad Producto</th>
						      <th scope="col">ID Producto</th>
						      <th scope="col">Stock Producto</th>
						      <th scope="col">Precio Unitario</th>
						    </tr>
						  </thead>
						  <tbody class="bg-light">
							  <% for(DetRequerimiento detReq:listRequerimientos.get(i).getDetRequerimientos()) {%>
					           	  <tr>
						               <th scope="row"><%out.println(detReq.getIdDetReq());%></td>
						               <td ><%out.println(detReq.getCantProDetReq());%></td>
						               <td><%out.println(detReq.getIdProdDetReq());%></td>
						               <td ><%out.println(detReq.getInvenProdDetReq());%></td>
						               <td ><%out.println(detReq.getPrecProdDetReq());%></td>
					          		</tr>
					              <% } %>
						  </tbody>
						</table>
					  </div>
				</div>
		  		<br>
			</div>
			<br>
		<%} %>
    </div>
       
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
    </div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script> 
	

    
    
    
    
</body>
</html>