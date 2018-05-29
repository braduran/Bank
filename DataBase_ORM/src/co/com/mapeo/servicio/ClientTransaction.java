package co.com.mapeo.servicio;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import co.com.mapeo.entity.Cliente;
import co.com.mapeo.entity.Prestamo;
import co.com.mapeo.entity.Response;
import co.com.utils.Constantes;
import co.com.utils.ServicesConfiguration;

public class ClientTransaction {
	   
     public Response insertarCliente(int id, String nombre, String apellido, String fechaNac) {
         EntityManagerFactory emfactory = null;
    	 EntityManager entitymanager = null;
    	 Response res = new Response();
    	 try{
    		 if(ServicesConfiguration.caluteYearDates(fechaNac) < 18) {
    			 res.setMessage(Constantes.LESS);
    	         res.setStatus(Constantes.ERROR);    
    	         return res;
    		 }
    		 
    		 emfactory = getEntityManagerFactory();
    		 entitymanager = emfactory.createEntityManager();
	         entitymanager.getTransaction().begin();
	
	         Cliente c = new Cliente(); 
	         c.setClienteID(id);
	         c.setNombre(nombre);
	         c.setApellido(apellido);
	         c.setFechaNacimiento(fechaNac);
	         
	         entitymanager.persist(c);
	         entitymanager.getTransaction().commit();
	         res.setMessage(Constantes.SUCCESS);
	         res.setStatus(Constantes.OK);
    	 }catch(Exception e) {
    		 res.setMessage(Constantes.FAILED);
	         res.setStatus(Constantes.ERROR);
	         e.printStackTrace();
    	 }finally {
    		 if(entitymanager != null) {
    			 entitymanager.close();
    		 }
    		 if(emfactory != null) {
    			 emfactory.close();
    		 }
    	 }
    	 return res;
     } 
     
     public Response insertarPrestamo(String nombreEmpresa, int nitEmpresa, double salarioActual, String fechaIngreso, int idCliente) {
    	 EntityManagerFactory emfactory = null;
         EntityManager entitymanager = null;
         Response res = new Response();
    	 try{
    		 if(ServicesConfiguration.caluteYearDates(fechaIngreso) < 1) {
    			 res.setMessage(Constantes.LESS_ONE_YEAR);
    	         res.setStatus(Constantes.ERROR);    
    	         return res;
    		 }
    		 
    		 double valorAprobado = ServicesConfiguration.validateSalary(salarioActual);
    		 if(valorAprobado == 0) {
    			 res.setMessage(Constantes.LOWER_SALARY);
    	         res.setStatus(Constantes.ERROR);    
    	         return res;
    		 }
    		 
    		 emfactory = getEntityManagerFactory();
	         entitymanager = emfactory.createEntityManager();
	         entitymanager.getTransaction().begin();
    		 
    		 Prestamo p = new Prestamo(); 
	         p.setNombreEmpresa(nombreEmpresa);
	         p.setNitEmpresa(nitEmpresa);
	         p.setSalarioActual(salarioActual);
	         p.setFechaIngreso(fechaIngreso);
	         p.setClienteId(idCliente);
	         p.setValorAprobado(valorAprobado);
	         
	         entitymanager.persist(p);
	         entitymanager.getTransaction().commit();
	         
	         NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
	         String currency = format.format(p.getValorAprobado());
	         
	         res.setMessage(Constantes.APPROVED_VALUE + currency);
	         res.setStatus(Constantes.OK);
    	 }catch(Exception e) {
    		 res.setMessage(Constantes.FAILED);
	         res.setStatus(Constantes.ERROR);
	         e.printStackTrace();
    	 }finally {
    		 if(entitymanager != null) {
    			 entitymanager.close();
    		 }
    		 if(emfactory != null) {
    			 emfactory.close();
    		 }
    	 }
    	 return res;
     } 
     
     public Response consultaCLiente(int id) {
         EntityManagerFactory emfactory = null;
    	 EntityManager entitymanager = null;
    	 Response res = new Response();
    	 try{
    		 emfactory = getEntityManagerFactory();
    		 entitymanager = emfactory.createEntityManager();
    		 
    		 Query query = entitymanager.createNamedQuery("find client");
    		 query.setParameter("id", id);
    		 
    		 List<Cliente> list = (List<Cliente>)query.getResultList();
    		 
    		 if(list.isEmpty()) {
    			 res.setMessage(Constantes.SUCCESS);
    	         res.setStatus(Constantes.OK);
    		 }else {
    	         res.setMessage(Constantes.USER_EXISTS);
    	         res.setStatus(Constantes.ERROR); 
    		 }
    	 }catch(Exception e) {
    		 res.setMessage(Constantes.FAILED);
	         res.setStatus(Constantes.ERROR);
	         e.printStackTrace();
    	 }finally {
    		 if(entitymanager != null) {
    			 entitymanager.close();
    		 }
    		 if(emfactory != null) {
    			 emfactory.close();
    		 }
    	 }
    	 return res;
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
