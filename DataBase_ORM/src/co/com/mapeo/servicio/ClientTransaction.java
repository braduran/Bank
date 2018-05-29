package co.com.mapeo.servicio;

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
     
     public void insertarPrestamo(String nombreEmpresa, int nitEmpresa, double salarioActual, String fechaIngreso, int idCliente) {
    	 EntityManagerFactory emfactory = null;
         EntityManager entitymanager = null;
    	 try{
    		 emfactory = getEntityManagerFactory();
	         entitymanager = emfactory.createEntityManager();
	         entitymanager.getTransaction().begin();
	
    		 Cliente cli = new Cliente();
    		 cli.setClienteID(idCliente);
    		 entitymanager.persist(cli);
    		 
    		 Prestamo p = new Prestamo(); 
	         p.setNombreEmpresa(nombreEmpresa);
	         p.setNitEmpresa(nitEmpresa);
	         p.setSalarioActual(salarioActual);
	         p.setFechaIngreso(fechaIngreso);
	         p.setCliente(cli);
	         
	         entitymanager.persist(p);
	         entitymanager.getTransaction().commit();
    	 }catch(Exception e) {
    		 e.printStackTrace();
    	 }finally {
    		 entitymanager.close();
	         emfactory.close();
    	 }
     } 
     
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
