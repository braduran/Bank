package co.com.mapeo.servicio;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import co.com.mapeo.entity.Cliente;
import co.com.mapeo.entity.Prestamo;

public class ClientTransaction {
	   
     public void insertarCliente(int id, String nombre, String apellido, String fechaNac) {
         EntityManagerFactory emfactory = null;
    	 EntityManager entitymanager = null;
    	 try{
    		 Cliente c = new Cliente(); 
    		 emfactory = getEntityManagerFactory();
    		 entitymanager = emfactory.createEntityManager();
	         entitymanager.getTransaction().begin();
	
	         c.setClienteID(id);
	         c.setNombre(nombre);
	         c.setApellido(apellido);
	         c.setFechaNacimiento(fechaNac);
	         
	         entitymanager.persist(c);
	         entitymanager.getTransaction().commit();
    	 }catch(Exception e) {
    		 e.printStackTrace();
    	 }finally {
    		 entitymanager.close();
    		 emfactory.close();
    	 }
     } 
     
     public void insertarPrestamo(String nombreEmpresa, int nitEmpresa, double salarioActual, Date fechaIngreso) {
    	 EntityManagerFactory emfactory = null;
         EntityManager entitymanager = null;
    	 try{
    		 Prestamo p = new Prestamo(); 
    		 emfactory = getEntityManagerFactory();
	         entitymanager = emfactory.createEntityManager();
	         entitymanager.getTransaction().begin();
	
	         p.setNombreEmpresa(nombreEmpresa);
	         p.setNitEmpresa(nitEmpresa);
	         p.setSalarioActual(salarioActual);
	         p.setFechaIngreso(fechaIngreso);
	         
	         entitymanager.persist(p);
	         entitymanager.getTransaction().commit();
    	 }catch(Exception e) {
    		 e.printStackTrace();
    	 }finally {
    		 entitymanager.close();
	         emfactory.close();
    	 }
     } 
     
     @SuppressWarnings("unused")
	private EntityManagerFactory getEntityManagerFactory() {
    	 EntityManagerFactory emfactory = null;
         try {
        	 emfactory = Persistence.createEntityManagerFactory("DataBase_ORM");
	    } catch (Exception e) {
			e.printStackTrace();
		}
        return emfactory;
     }
}
