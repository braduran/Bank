package co.com.microserviciopaquete;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.mapeo.servicio.ClientTransaction;

@RestController
public class Microservicio {
	   
	@RequestMapping(method = RequestMethod.POST, path = "/insertarCliente")
	public void insertarCliente(@RequestParam(value = "id") int id,
								@RequestParam(value = "nombre") String nombre,
					            @RequestParam(value = "apellido")String apellido,
					            @RequestParam(value = "fechaNac") Date fechaNac){
		ClientTransaction create = new ClientTransaction();
	    create.insertarCliente(id, nombre, apellido, fechaNac);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/insertarPrestamo")
	public void insertarPrestamo(@RequestParam(value = "nombreEmpresa") String nombreEmpresa,
								 @RequestParam(value = "nitEmpresa") int nitEmpresa,
					             @RequestParam(value = "salarioActual")double salarioActual,
					             @RequestParam(value = "fechaIngreso") Date fechaIngreso){
		ClientTransaction create = new ClientTransaction();
	    create.insertarPrestamo(nombreEmpresa, nitEmpresa, salarioActual, fechaIngreso);
	}
}
