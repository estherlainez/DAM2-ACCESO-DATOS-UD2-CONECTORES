package Modelo;

public class Empleado {
	private String dni;
	private String nombre;
	private String apellidos;
	private double salario;
	private int dpto;
	
	public Empleado() {
		this.dni=dni;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.salario=salario;
		this.dpto=dpto;
	}
	
	public Empleado(String d,String n, String a,double s,int de) {
		this.dni=d;
		this.nombre=n;
		this.apellidos=a;
		this.salario=s;
		this.dpto=de;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getDpto() {
		return dpto;
	}

	public void setDpto(int dpto) {
		this.dpto = dpto;
	}

	@Override
	public String toString() {
		return "Empleado [Dni=" + dni + ", Nombre=" + nombre + ", Apellidos=" + apellidos + ", Salario=" + salario
				+ ", Dpto=" + dpto + "]";
	}

	
	
	
	

}
