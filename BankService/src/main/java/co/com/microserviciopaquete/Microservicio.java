package co.com.microserviciopaquete;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.mapeo.servicio.CrearCliente;

@RestController
public class Microservicio {
	   
	@RequestMapping(method = RequestMethod.POST, path = "/insertar")
	public void insertar(@RequestParam(value = "id") int id,
						 @RequestParam(value = "nombre") String nombre,
			             @RequestParam(value = "apellido")String apellido,
			             @RequestParam(value = "fechaNac") String fechaNac){
		CrearCliente create = new CrearCliente();
	    create.insertarCliente(id, nombre, apellido, fechaNac);
	}
}
