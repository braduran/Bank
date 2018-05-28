package co.com.mapeo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="registro")
public class Cliente {

	 @Id
	 private int clienteID;
	 private String nombre;
	 private String apellido;
	 private String fechaNacimiento;
	 
	public Cliente() {}

	public Cliente(int id, String nombre, String apellido, String fechNac) {
		this.clienteID = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechNac;
	}

	public int getClienteID() {
		return clienteID;
	}

	public void setClienteID(int clienteID) {
		this.clienteID = clienteID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
}
