package ec.edu.ups.test;
import java.util.GregorianCalendar;



import ec.edu.ups.dao.*;
import ec.edu.ups.modelo.*;

public class TestGeneral {

	public static void main(String[] args) {
		EmpresaDAO empresaDAO = DAOFactory.getFactory().getEmpresaDAO();
		UsuarioDAO usuarioDAO = DAOFactory.getFactory().getUsuarioDAO();
		ProductosDAO productosDAO = DAOFactory.getFactory().getProductosDAO();
		CatProductoDAO catProductoDAO = DAOFactory.getFactory().getCatProductoDAO();
		RequerimientosDAO requerimientosDAO = DAOFactory.getFactory().getRequerimientosDAO();
		DetRequerimientoDAO detRequerimientoDAO = DAOFactory.getFactory().getDetRequerimientoDAO();
		
		empresaDAO.createTable();
		usuarioDAO.createTable();
		catProductoDAO.createTable();
		productosDAO.createTable();
		requerimientosDAO.createTable();
		detRequerimientoDAO.createTable();
		
		///////////////////CREAR EMPRESAS////////////////////////////////////////
		Empresa megaPlazaDelSur = new Empresa (1,"Plaza Del Sur","Ucubamba");
		Empresa megaTiendaDelSur = new Empresa (2,"Mega Tienda Del Sur","Indurama");
		Empresa megaTiendaSantaCecilia = new Empresa (3,"Mega Santa Cecilia","9DeOctubre");
		
		empresaDAO.create(megaTiendaSantaCecilia);
		empresaDAO.create(megaTiendaDelSur);
		empresaDAO.create(megaPlazaDelSur);
		
		
		//////////////////////CREANDO USUARIOS ADMINISTRADORES/////////////
		
		Usuario usuarioAdm = new Usuario(1,"Jessica Guncay","gjessica@est.ups.edu.ec","Jessica123",'A');
		usuarioAdm.setEmpresa(megaTiendaDelSur);
		//System.out.println(usuarioAdm.getTipoUsu());
		usuarioDAO.create(usuarioAdm);
		 

	
		Usuario usuarioAmdPDS = new Usuario(2, "William Sinchi", "wsinchi@est.ups.edu.ec", "William123",'A');
		usuarioAmdPDS.setEmpresa(megaPlazaDelSur);
		usuarioDAO.create(usuarioAmdPDS);
	
	
		Usuario usuarioAmdMSC = new Usuario(3, "Karla Agudo", "kagudo@est.ups.edu.ec", "Karla123",'A');
		//empresaDAO.create(megaTiendaSantaCecilia);
		usuarioAmdMSC.setEmpresa(megaTiendaSantaCecilia);
		usuarioDAO.create(usuarioAmdMSC); 
		
		///////////////////CREANDO USUARIOS NORMALES/////////////
		
		Usuario usuarioMSC = new Usuario(4, "Valeria Guncay", "gvaleria@est.ups.edu.ec", "Valeria123",'N');
		//empresaDAO.create(megaTiendaSantaCecilia);
		usuarioMSC.setEmpresa(megaTiendaSantaCecilia);
		usuarioDAO.create(usuarioMSC); 
		
		Usuario usuarioPDS = new Usuario(5, "Jessica Sinchi", "jsinchi@est.ups.edu.ec", "JessicaP123",'N');
		usuarioPDS.setEmpresa(megaPlazaDelSur);
		usuarioDAO.create(usuarioPDS);
		
		Usuario usuarioMTS = new Usuario(6,"Carmen Calderon","ccarmen@est.ups.edu.ec","Carmen123",'N');
		usuarioMTS.setEmpresa(megaTiendaDelSur);
		usuarioDAO.create(usuarioMTS);
		
		
		
		
		/*Requerimiento compraCarne = new Requerimiento(1, new GregorianCalendar(2020, 3, 20),"Carlos","LLega en dos dias", 'A');
		
		compraCarne.setUsuario(usuarioAdm);
		requerimientosDAO.create(compraCarne);
		
		
		DetRequerimiento reComprCa = new DetRequerimiento(1, 1, 1, 2, 3.25, 1);
		
		reComprCa.setRequerimiento(compraCarne);
		detRequerimientoDAO.create(reComprCa);*/
		
		
		//////////////////CREAR CATEGORIAS/////////////////
		CatProducto carnesMTS = new CatProducto(1, "Carnes");
		CatProducto lacteosMTS = new CatProducto(2, "Lacteos");
		CatProducto bebidasMTS = new CatProducto(3, "Bebidas");
		CatProducto fiestaMTS = new CatProducto(4, "Fiesta");
		catProductoDAO.create(bebidasMTS);
		catProductoDAO.create(carnesMTS);
		catProductoDAO.create(lacteosMTS);
		catProductoDAO.create(fiestaMTS);
		
		
		CatProducto frutasMPS = new CatProducto(5, "Frutas");
		CatProducto jugueMPS = new CatProducto(6, "Jugueteria");
		CatProducto panaMPS = new CatProducto(7, "Panaderia");
		CatProducto vestiMPS= new CatProducto(8, "Vestimenta");	
		catProductoDAO.create(frutasMPS);
		catProductoDAO.create(jugueMPS);
		catProductoDAO.create(panaMPS);
		catProductoDAO.create(vestiMPS);
		
		
		
		
		CatProducto licoMTSC = new CatProducto(9, "Licores");
		CatProducto papeMTSC = new CatProducto(10, "Papeleria");
		CatProducto limpiezaMTSC = new CatProducto(11, "Limpieza");
		CatProducto calzadoMTSC = new CatProducto(12, "Calzado");
		catProductoDAO.create(licoMTSC);
		catProductoDAO.create(papeMTSC);
		catProductoDAO.create(limpiezaMTSC);
		catProductoDAO.create(calzadoMTSC);
		

		
		
//////////////////CREA PRODUCTOS EN MEGA TIENDA DEL SUR/////////////////

		/////CATEGORIA CARNES
		Productos proCarRes = new Productos (1 , "Carne Res",3.25, 10);
		proCarRes.setCatProd(carnesMTS);
		proCarRes.setEmpresa(megaTiendaDelSur);		
		productosDAO.create(proCarRes);
	
		Productos proPollo = new Productos (2 , "Pollo",3.10, 10);
		proPollo.setCatProd(carnesMTS);
		proPollo.setEmpresa(megaTiendaDelSur);		
		productosDAO.create(proPollo);
	
		Productos proCarChan= new Productos (3 , "Carne Chancho",3.50, 12);
		proCarChan.setCatProd(carnesMTS);
		proCarChan.setEmpresa(megaTiendaDelSur);		
		productosDAO.create(proCarChan);
		
		
		//////CATEGORIA LACTEOS
		Productos proYogurt= new Productos (4 , "Yogurt",0.85, 10);
		proYogurt.setCatProd(lacteosMTS);
		proYogurt.setEmpresa(megaTiendaDelSur);		
		productosDAO.create(proYogurt);
		
		Productos proLeche= new Productos (5 , "Leche",0.85, 10);
		proLeche.setCatProd(lacteosMTS);
		proLeche.setEmpresa(megaTiendaDelSur);		
		productosDAO.create(proLeche);
		
		Productos proQueso= new Productos (6 , "Queso",0.85, 10);
		proQueso.setCatProd(lacteosMTS);
		proQueso.setEmpresa(megaTiendaDelSur);		
		productosDAO.create(proQueso);
		
		///// CATEGORIA BEBIDAS
		Productos proBeCo = new Productos (7 , "Coca-Cola",2.85, 12);
		proBeCo.setCatProd(bebidasMTS);
		proBeCo.setEmpresa(megaTiendaDelSur);
		productosDAO.create(proBeCo);
		
		Productos proBeVi = new Productos (8 , "Vivant",0.45, 15);
		proBeVi.setCatProd(bebidasMTS);
		proBeVi.setEmpresa(megaTiendaDelSur);
		productosDAO.create(proBeVi);
		
		Productos proBeGui = new Productos (9 , "Guitic",0.75, 10);
		proBeGui.setCatProd(bebidasMTS);
		proBeGui.setEmpresa(megaTiendaDelSur);
		productosDAO.create(proBeGui);
		
		///// CATEGORIA FIESTA
	
		Productos proGlo = new Productos (10 , "Globos",1.5, 14);
		proGlo.setCatProd(fiestaMTS);
		proGlo.setEmpresa(megaTiendaDelSur);
		productosDAO.create(proGlo);
		
		Productos proSer = new Productos (11 , "Serpentinas",1.5, 11);
		proSer.setCatProd(fiestaMTS);
		proSer.setEmpresa(megaTiendaDelSur);
		productosDAO.create(proSer);
		
		Productos proPin = new Productos (12 , "Piñata",8.5, 11);
		proPin.setCatProd(fiestaMTS);
		proPin.setEmpresa(megaTiendaDelSur);
		productosDAO.create(proPin);

//////////////////CREA PRODUCTOS EN MEGA PLAZA SUR/////////////////	
		
		///////CATEGORIA FRUTAS
		Productos proMPSManzana = new Productos (13 , "Manzana",0.55, 10);
		proMPSManzana.setCatProd(frutasMPS);
		proMPSManzana.setEmpresa(megaPlazaDelSur);
		productosDAO.create(proMPSManzana);
		
		Productos proMPSSandias = new Productos (14 , "Sandias",1.55, 12);
		proMPSSandias.setCatProd(frutasMPS);
		proMPSSandias.setEmpresa(megaPlazaDelSur);
		productosDAO.create(proMPSSandias);
		
		Productos proMPSPeras = new Productos (15 , "Peras",0.60, 10);
		proMPSPeras.setCatProd(frutasMPS);
		proMPSPeras.setEmpresa(megaPlazaDelSur);
		productosDAO.create(proMPSPeras);
		
		///////CATEGORIA JUGUETERIA
		Productos proMPSBar = new Productos (16 , "Barbie",10.55, 12);
		proMPSBar.setCatProd(jugueMPS);
		proMPSBar.setEmpresa(megaPlazaDelSur);
		productosDAO.create(proMPSBar);
		
		Productos proMPSPeBa = new Productos (17 , "Pelota de Basquet",19.75, 11);
		proMPSPeBa.setCatProd(jugueMPS);
		proMPSPeBa.setEmpresa(megaPlazaDelSur);
		productosDAO.create(proMPSPeBa);
		
		Productos proMPSPeFu = new Productos (18 , "Pelota de Futol",18.65, 15);
		proMPSPeFu.setCatProd(jugueMPS);
		proMPSPeFu.setEmpresa(megaPlazaDelSur);
		productosDAO.create(proMPSPeFu);
		
		///////CATEGORIA PANADERIA
		Productos proMPSPanEn = new Productos (19 , "Pan enrollado",0.25, 10);
		proMPSPanEn.setCatProd(panaMPS);
		proMPSPanEn.setEmpresa(megaPlazaDelSur);
		productosDAO.create(proMPSPanEn);
		
		Productos proMPSPanEnq = new Productos (20 , "Pan enquesillado",0.25, 13);
		proMPSPanEnq.setCatProd(panaMPS);
		proMPSPanEnq.setEmpresa(megaPlazaDelSur);
		productosDAO.create(proMPSPanEnq);
		
		Productos proMPSTorGran = new Productos (21 , "Torta Grande", 12.50, 10);
		proMPSTorGran.setCatProd(panaMPS);
		proMPSTorGran.setEmpresa(megaPlazaDelSur);
		productosDAO.create(proMPSTorGran);
		
		Productos proMPSTorMEd = new Productos (22 , "Torta Mediana",6.25, 15);
		proMPSTorMEd.setCatProd(panaMPS);
		proMPSTorMEd.setEmpresa(megaPlazaDelSur);
		productosDAO.create(proMPSTorMEd);
		
		///////CATEGORIA VESTIMENTA  
		Productos proMPSCamisa= new Productos (23 , "Camisa",8.25, 10);
		proMPSCamisa.setCatProd(vestiMPS);
		proMPSCamisa.setEmpresa(megaPlazaDelSur);
		productosDAO.create(proMPSCamisa);
		
		Productos proMPSPantalon= new Productos (24 , "Pantalon",15.75, 15);
		proMPSPantalon.setCatProd(vestiMPS);
		proMPSPantalon.setEmpresa(megaPlazaDelSur);
		productosDAO.create(proMPSPantalon);
		
		Productos proMPSCamiseta= new Productos (25 , "Camiseta",10.75, 12);
		proMPSCamiseta.setCatProd(vestiMPS);
		proMPSCamiseta.setEmpresa(megaPlazaDelSur);
		productosDAO.create(proMPSCamiseta);
		
		Productos proMPSVestido= new Productos (26 , "Vestido",18.50, 15);
		proMPSVestido.setCatProd(vestiMPS);
		proMPSVestido.setEmpresa(megaPlazaDelSur);
		productosDAO.create(proMPSVestido);
		
//////////////////CREA PRODUCTOS EN MEGA SANTA CECILIA/////////////////			
		
		/////CATEGORIA LICORES
		Productos proMCSCerveza= new Productos (27 , "Cerveza",2.25, 15);
		proMCSCerveza.setCatProd(licoMTSC);
		proMCSCerveza.setEmpresa(megaTiendaSantaCecilia);
		productosDAO.create(proMCSCerveza);
		
		Productos proMSCWis= new Productos (28 , "Whisky",12.25, 10);
		proMSCWis.setCatProd(licoMTSC);
		proMSCWis.setEmpresa(megaTiendaSantaCecilia);
		productosDAO.create(proMSCWis);
		
		Productos proMPSZhu= new Productos (29 , "Zhumir",5.25, 15);
		proMPSZhu.setCatProd(licoMTSC);
		proMPSZhu.setEmpresa(megaTiendaSantaCecilia);
		productosDAO.create(proMPSZhu);
		
		/////CATEGORIA PAPELERIA
		Productos proMSCCuadernos= new Productos (30 , "Cuadernos",2.25, 15);
		proMSCCuadernos.setCatProd(papeMTSC);
		proMSCCuadernos.setEmpresa(megaTiendaSantaCecilia);
		productosDAO.create(proMSCCuadernos);
		
		Productos proMSCEsferos= new Productos (31 , "Esferos", 0.25, 20);
		proMSCEsferos.setCatProd(papeMTSC);
		proMSCEsferos.setEmpresa(megaTiendaSantaCecilia);
		productosDAO.create(proMSCEsferos);
		
		Productos proMSCCarpetas= new Productos (32 , "Carpetas",5.25, 15);
		proMSCCarpetas.setCatProd(papeMTSC);
		proMSCCarpetas.setEmpresa(megaTiendaSantaCecilia);
		productosDAO.create(proMSCCarpetas);
		
		/////CATEGORIA LIMPIEZA
		Productos proMSCDetergente= new Productos (33 , "Detergente",4.25, 15);
		proMSCDetergente.setCatProd(limpiezaMTSC);
		proMSCDetergente.setEmpresa(megaTiendaSantaCecilia);
		productosDAO.create(proMSCDetergente);
		
		Productos proMSCCloro= new Productos (34 , "Cloro", 0.25, 30);
		proMSCCloro.setCatProd(limpiezaMTSC);
		proMSCCloro.setEmpresa(megaTiendaSantaCecilia);
		productosDAO.create(proMSCCloro);
		
		Productos proMSCVanish= new Productos (35 , "Vanish",1.25, 20);
		proMSCVanish.setCatProd(limpiezaMTSC);
		proMSCVanish.setEmpresa(megaTiendaSantaCecilia);
		productosDAO.create(proMSCVanish);
		
		
		/////CATEGORIA CALZADO
		Productos proMSCTacones= new Productos (36 , "Tacones",15.75, 25);
		proMSCTacones.setCatProd(calzadoMTSC);
		proMSCTacones.setEmpresa(megaTiendaSantaCecilia);
		productosDAO.create(proMSCTacones);
		
		Productos proMSCDepHom= new Productos (37 , "Deportivos Hombre", 10.5, 30);
		proMSCDepHom.setCatProd(calzadoMTSC);
		proMSCDepHom.setEmpresa(megaTiendaSantaCecilia);
		productosDAO.create(proMSCDepHom);
		
		Productos proMSCAdidas= new Productos (38 , "Adidas",71.25, 20);
		proMSCAdidas.setCatProd(calzadoMTSC);
		proMSCAdidas.setEmpresa(megaTiendaSantaCecilia);
		productosDAO.create(proMSCAdidas);
	}

}
