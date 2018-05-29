package co.com.mapeo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="prestamo")
public class Prestamo {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO) 
	private int id;
	private String nombreEmpresa;
	private int nitEmpresa;
	private double salarioActual;
	private String fechaIngreso;
	
	@JoinColumn(name = "ClienteID")
	private int clienteId;
	
	public Prestamo() {}
	
	public Prestamo(int id, String nombreEmpresa, int nitEmpresa, double salarioActual, String fechaIngreso) {
		this.id = id;
		this.nombreEmpresa = nombreEmpresa;
		this.nitEmpresa = nitEmpresa;
		this.salarioActual = salarioActual;
		this.fechaIngreso = fechaIngreso;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public int getNitEmpresa() {
		return nitEmpresa;
	}
	public void setNitEmpresa(int nitEmpresa) {
		this.nitEmpresa = nitEmpresa;
	}
	public double getSalarioActual() {
		return salarioActual;
	}
	public void setSalarioActual(double salarioActual) {
		this.salarioActual = salarioActual;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public int getClienteId() {
		return clienteId;
	}
	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}
}
