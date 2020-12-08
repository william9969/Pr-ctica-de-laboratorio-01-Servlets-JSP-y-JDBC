<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="ec.edu.ups.modelo.Productos" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Productos</title>
<link rel="stylesheet" type="text/css" href="CSS/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="CSS/CSSADD.css"/>
<link rel="stylesheet" href="CSS/style.css"/>
</head>
<body>
	
	<div class="container-md"> 
	<div class="Cabecera">
		<form action="http://localhost:8080/Practica01/Sesion" method="get">
		
		 <div class="form-row align-items-center">
		  
		  	<div class="col-auto">
		      <label class="sr-only" for="inlineFormInputGroup" type="pas" >Usuario</label>
		      <div class="input-group mb-2">
		        <div class="input-group-prepend">
		          <div class="input-group-text">Usuario</div>
		        </div>
		        <input type="text" class="form-control" id="inlineFormInputGroup" name="usuario" placeholder="Ingrese usuario">
		      </div>
		    </div>
		  
		  
		    <div class="col-auto">
				<label class="sr-only" for="inputPassword6" name="contralabel">Password</label>
				
				<div class="input-group mb-2">
		        <div class="input-group-prepend">
		          <div class="input-group-text">Contraseña</div>
		        </div>
		        <input type="password" id="inlineFormInputGroup" class="form-control" aria-describedby="passwordHelpInline" name="contrasena" placeholder="Ingrese contraseña">
		      </div>
		    	
		    </div>
		    <div class="col-auto">
		      <button type="submit" class="btn btn-dark mb-2">Submit</button>
		    </div>
		  </div>
		</form>
	</div>
	
	
		<% Productos product = new Productos(); %> 
		<% ArrayList<Productos> list= new ArrayList<Productos>();  %> 
		<% list = (ArrayList<Productos>) request.getAttribute("productos"); %>
	       
	       
	       <table class="table">
			  <thead class="thead-dark">
			    <tr>
			      <th scope="col">ID</th>
			      <th scope="col">Nombre</th>
			      <th scope="col">Precio</th>
			    </tr>
			  </thead>
			  <tbody class="bg-light">
				  <% for(int i = 0; i < list.size(); i++) {%>
		           	  <tr>
					<% product = list.get(i); %>
		               <th scope="row"><%out.println(product.getIdProd());%></td>
		               <td ><%out.println(product.getNomProd());%></td>
		               <td><%out.println(product.getPrecProd());%></td>
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
    </div>
	
	
	 
	
</body>
</html>