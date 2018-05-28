package co.com.mapeo.servicio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import co.com.mapeo.entity.Cliente;

public class CrearCliente {
	   
     public void insertarCliente(int id, String nombre, String apellido, String fechaNac) {
    	 Cliente c = new Cliente(); 
    	 EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("DataBase_JPA");
         EntityManager entitymanager = emfactory.createEntityManager( );
         entitymanager.getTransaction( ).begin( );

         c.setClienteID(id);
         c.setNombre(nombre);
         c.setApellido(apellido);
         c.setFechaNacimiento(fechaNac);
         
         entitymanager.persist(c);
         entitymanager.getTransaction( ).commit( );

         entitymanager.close( );
         emfactory.close( );
     } 
}
