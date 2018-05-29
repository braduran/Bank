package co.com.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.mapeo.entity.Response;
import co.com.mapeo.servicio.ClientTransaction;

@RestController
public class Microservicio {
	   
	@RequestMapping(method = RequestMethod.POST, path = "/insertarCliente")
	public Response insertarCliente(@RequestParam(value = "id") int id,
								@RequestParam(value = "nombre") String nombre,
					            @RequestParam(value = "apellido")String apellido,
					            @RequestParam(value = "fechaNac") String fechaNac){
		ClientTransaction create = new ClientTransaction();
	    return create.insertarCliente(id, nombre, apellido, fechaNac);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/insertarPrestamo")
	public Response insertarPrestamo(@RequestParam(value = "nombreEmpresa") String nombreEmpresa,
								 @RequestParam(value = "nitEmpresa") int nitEmpresa,
					             @RequestParam(value = "salarioActual")double salarioActual,
					             @RequestParam(value = "fechaIngreso") String fechaIngreso,
					             @RequestParam(value = "idCliente") int idCliente){
		ClientTransaction create = new ClientTransaction();
	    return create.insertarPrestamo(nombreEmpresa, nitEmpresa, salarioActual, fechaIngreso, idCliente);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/consultarCliente")
	public Response consultarCliente(@RequestParam(value = "id") int id){
		ClientTransaction create = new ClientTransaction();
	    return create.consultaCLiente(id);
	}
}
