package co.com.model;

public class Estudiantes {

	String nombre;
	String materia;
	double nota;
	
	public Estudiantes() {
		super();
	}

	public Estudiantes(String nombre, String materia, double nota) {
		super();
		this.nombre = nombre;
		this.materia = materia;
		this.nota = nota;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
	
	
}
