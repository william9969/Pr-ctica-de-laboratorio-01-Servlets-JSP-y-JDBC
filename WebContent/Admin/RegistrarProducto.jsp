<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="ec.edu.ups.modelo.Usuario" %>
    <%@ page import="ec.edu.ups.modelo.CatProducto" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Registar Productos</title>
	<link rel="stylesheet" type='text/css' href="<%=request.getContextPath()%>/CSS/bootstrap-grid.css" />     
	<link rel="stylesheet" type='text/css' href="<%=request.getContextPath()%>/CSS/bootstrap.css"/>
	<link rel="stylesheet" type='text/css' href="<%=request.getContextPath()%>/CSS/style.css"/>

</head>
<body id="home" data-spy="scroll" data-target="#navbar-wd" data-offset="98">

	<% HttpSession sesion=request.getSession(); %>
	<% Usuario usr=(Usuario)sesion.getAttribute("usr");%>
	<% CatProducto catP = new CatProducto(); %>
	<% ArrayList<CatProducto> list= (ArrayList<CatProducto>) sesion.getAttribute("cat"); %>
	
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
    <!--CREAR FORMULARIO DE REGISTRO-->
        <div class="card text-center">
        <div class="card-header  bg-dark"> </div>
      </div>
    <div class="section about_section layout_padding dash_bg ">  
        <div class="text-center bg-light ">
            <img src="<%=request.getContextPath()%>/Imagenes/agregarP.png" class="rounded" alt="...">
            <div class="heading_main text_align_center bg-light">
                <h2>Registro de Productos</h2>
            </div>
        </div>
        <div class="container bg-secondary">
            <form action="http://localhost:8080/Practica01/RegistrarProducto" method="get">
               
                <div class="form-row">
                    <div class="col">
                        <label for="exampleFormControlInput1 " class ="text-white">Nombre </label>
                        <input type="text" class="form-control" name="nomProdR" placeholder="Nombre del Producto ..">
                    </div>
                    <div class="col">
                        <label for="exampleFormControlInput1 " class = "text-white">Precio </label>
                        <input type="text" class="form-control" name="precProR" placeholder="Precio">
                    </div>
                  </div>
                <br>
                <div class="form-group ">
                    <label for="exampleFormControlInput1 " class= "text-white" >Cantidad </label>
                    <input type="text" class="form-control"  name="canProR" placeholder="Cantidad">
                </div>
                <div class="form-row">
                    <div class="col">
                        <label for="exampleFormControlInput1 " class = "text-white">Empresa </label>
                        <input type="text" class="form-control" value="<%out.println(usr.getEmpresa().getNomEmp());%>" disabled="disabled">
                    </div>
                    <div class="col">
                    	<label for="exampleFormControlInput1 " class="text-white" data-toggle="popover" data-placement="bottom"  data-content="" >Categoria</label>
                        <input type="text" class="form-control" name="catProR" title="<% for(int i = 0; i < list.size(); i++) { catP = list.get(i); out.println("ID:"+catP.getIdCatProd()+"  "+"Nombre:"+ catP.getNomCatProd());
						} %>" placeholder="Ingrese ID de la categoria">
                    </div>
                  </div>
                  <br>
                  <button type="submit" class="btn btn-primary">Registrar</button>
               
            </form>
               <br>
        </div> 
    </div>
    </div>
	
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