package Modelo;

import java.io.Serializable;

public class Departamento implements Serializable{
	private int id;
	private String nombre;
	
	public Departamento() {
		this.id=id;
		this.nombre=nombre;
	}
	
	public Departamento(int i,String n) {
		this.id=i;
		this.nombre=n;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Departamento [ID=" + id + ", Nombre=" + nombre + "]";
	}

}
