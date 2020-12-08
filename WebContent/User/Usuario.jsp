<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>Page Title</title>
    <link rel="stylesheet" type='text/css' href="<%=request.getContextPath()%>/CSS/bootstrap-grid.css" />
      
    <link rel="stylesheet" type='text/css' href="<%=request.getContextPath()%>/CSS/bootstrap.css" />

    <link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/style.css" />
</head>

<body id="home" data-spy="scroll" data-target="#navbar-wd" data-offset="98">
          <header class ="float-right">
            <ul class="nav justify-content-end">

                <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/User/Usuario.jsp">  Inicio</a>
                </li>
                <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/User/ListarProductos.jsp">Productos</a>
                </li>
                
                <li class="nav-item">
		                <a class="nav-link" href="<%=request.getContextPath()%>/User/Requerimiento.jsp">Solicitar Requerimiento</a>
                </li>
                  <li class="nav-item">
		                <a class="nav-link" href="<%=request.getContextPath()%>/User/ListarRequerimientos.jsp">Listar Requerimiento</a>
                </li>
                
                <li class="nav-item">
                	<form action="http://localhost:8080/Practica01/LogOut" method="get">
	             		 <button type="submit" class="nav-link btn-danger">Salir</button>
	             	</form>
                </li>
              </ul>
            
        </header>
        

          <div class="section about_section layout_padding dash_bg">
            <div class="container">
               <div class="row">
                  <div class="col-md-12">
                     <div class="full">
                        <div class="heading_main text_align_center">
                           <h2>¿Qué quieres hacer?</h2>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="row">
                  <div class="col-xs-6 col-sm-6 col-md-6 col-lg-3">
                     <div class="full feature_box">
                         <div class="full icon">
                            <a href=""><img class="default-block" src="<%=request.getContextPath()%>/Imagenes/empresaIC.png" alt="#" /></a>
                            <a href=""><img class="default-none" src="<%=request.getContextPath()%>/Imagenes/empresaIC.png" alt="#" /></a>
                         </div>
                         <div class="full">
                            <h4>Empresa</h4>
                         </div>
                         <div class="full">
                           <p>Datos importantes sobre nuestra empresa, además nuestros colaboradores.</p>
                         </div>
                     </div>
                  </div>
                  <div class="col-xs-6 col-sm-6 col-md-6 col-lg-3">
                     <div class="full feature_box">
                         <div class="full icon">
                            <a href="<%=request.getContextPath()%>/User/ListarProductos.jsp"><img class="default-block" src="<%=request.getContextPath()%>/Imagenes/prodIC.png" alt="#" /></a>
                            <a href="<%=request.getContextPath()%>/User/ListarProductos.jsp"><img class="default-none" src="<%=request.getContextPath()%>/Imagenes/prodIC.png" alt="#" /></a>
                         </div>
                         <div class="full">
                            <h4>Productos</h4>
                         </div>
                         <div class="full">
                           <p>Puedes revisar los productos existentes en la empresa y listarlos.</p>
                         </div>
                     </div>
                  </div>
                  <div class="col-xs-6 col-sm-6 col-md-6 col-lg-3">
                     <div class="full feature_box">
                         <div class="full icon">
                            <a href="<%=request.getContextPath()%>/User/Requerimiento.jsp"><img class="default-block" src="<%=request.getContextPath()%>/Imagenes/requeIC.png" alt="#" /></a>
                            <a href="<%=request.getContextPath()%>/User/Requerimiento.jsp"><img class="default-none" src="<%=request.getContextPath()%>/Imagenes/requeIC.png" alt="#" /></a>
                         </div>
                         <div class="full">
                            <h4>Requerimientos</h4>
                         </div>
                         <div class="full">
                           <p>Puedes revisar los requerimientos de compra que han hecho los usuarios</p>
                         </div>
                     </div>
                  </div>
                  <div class="col-xs-6 col-sm-6 col-md-6 col-lg-3">
                     <div class="full feature_box">
                         <div class="full icon">
                            <a href="<%=request.getContextPath()%>/User/UsuarioPerfil.jsp"><img class="default-block" src="<%=request.getContextPath()%>/Imagenes/usuIC.png" alt="#" /></a>
                            <a href="<%=request.getContextPath()%>/User/UsuarioPerfil.jsp"><img class="default-none" src="<%=request.getContextPath()%>/Imagenes/usuIC.png" alt="#" /></a>
                         </div>
                         <div class="full">
                            <h4>Mi Perfil</h4>
                         </div>
                         <div class="full">
                           <p>Revisa tus datos personales para saber si los datos guardados son correctos.</p>
                         </div>
                     </div>
                  </div>
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