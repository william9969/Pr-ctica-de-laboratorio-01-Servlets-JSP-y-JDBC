/**
 * 
 */

var cantidadproductos;

window.onload = function () {/*hace que se cargue la función lo que predetermina que div estará oculto hasta llamar a la función nuevamente*/
   
    cantidadproductos = 0;
    document.getElementById("cantidadFactura").value = 0;
}

var productos = [];
function agregarFila(){
	
	var esta = false;
	var table = document.getElementById("totalProductos");
    var e = document.getElementById("products");
    var producto = e.options[e.selectedIndex].text;
    var precio = e.options[e.selectedIndex].id;
    var idProd = e.options[e.selectedIndex].value;
    //var fecha = document.getElementById("fecha").value;
    //var precioCom = document.getElementById("precompra").value;
    var descuento = document.getElementById("descuento").value;
    var cantidad = document.getElementById("canticompra").value;
	for (var i = 0; i < productos.length; i++) {
        if (productos[i] == idProd) {
            esta = true;

        }
        console.log(productos[i]);
    }
	
	if (!esta){
		if (precio != "" && cantidad != ""){
			productos.push(idProd);
			//console.log(productos.push(idProd));
			cantidadproductos = document.getElementById("cantidadFactura").value;
			cantidadproductos++;
			document.getElementById("cantidadFactura").value =cantidadproductos; 
			var rowCount = table.rows.length;
			console.log(idProd);
			console.log(cantidadproductos);
			//console.log(fecha);
			table.insertRow(-1).innerHTML = '<td><input type="number" name="id'+cantidadproductos+'" value="'+idProd+'" readonly></td><td><input type="text" name="prod' + cantidadproductos + '" value="' + producto + '" readonly ></td><td><input type="number" name="precio' + cantidadproductos + '" value="' + precio + '" readonly> </td><td><input type="number" name="descuento' + cantidadproductos + '" value="' + descuento + '" readonly> </td><td><input type="number" name="cantidad' + cantidadproductos + '" value="' + cantidad + '" readonly></td>';
			
		}else{
			alert("Ingrese descuento y cantidad");
		}
	} else {
		alert("El producto ya existe");
	}
	
	function idCompra(id){
    var idCompra=document.getElementById(id).name;
    document.getElementByName("idcompra").value=idCompra;
    
	}
	
}
function eliminarFila() {
    var table = document.getElementById("totalProductos");
    var rowCount = table.rows.length;
    //console.log(rowCount);

    if (rowCount <= 1)
        alert('No se puede eliminar el encabezado');
    else
        table.deleteRow(rowCount - 1);
    cantidadproductos = document.getElementById("cantidadFactura").value;
    cantidadproductos--;
    document.getElementById("cantidadFactura").value = cantidadproductos;
    productos.pop();
}