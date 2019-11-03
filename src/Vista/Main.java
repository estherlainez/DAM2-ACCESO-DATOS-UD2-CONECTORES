package Vista;
import java.util.*;

import Controller.DepartamentoController;
import Controller.EmpleadoController;
import Modelo.Departamento;
import Modelo.Empleado;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion;
		do {
			Scanner teclado=new Scanner(System.in);
			System.out.println("MENU");
			System.out.println("1.Consultar todos los empleados");
			System.out.println("2.Consultar empleados por dni");
			System.out.println("3.Consultar por saldo mayor a.....");
			System.out.println("4.Consultar por salario igual o inferior a....");
			System.out.println("5.Insertar empleado");
			System.out.println("6.Modificar empleado");
			System.out.println("7.Borrar empleado");
			System.out.println("8.Listar los empleados de un departamento");
			System.out.println("9.Insertar departamento");
			System.out.println("10.Modificar departamento");
			System.out.println("11.Eliminar un departamento");
			System.out.println("12.Mostrar departamentos");
			System.out.println("13.Ver informacion de un departamento, a buscar por ID");
			System.out.println("14.Ver informacion de un departamento, a buscar por nombre");
			System.out.println("15.Subir sueldo a los empleados de un departamento");
			System.out.println("16.Salir");
			opcion=teclado.nextInt();
			switch(opcion) {
			case 1:
				System.out.println("Consulta de todos los empleados");
				EmpleadoController con=new EmpleadoController();
				con.mostrarEmpleados();
				break;
			case 2:
				teclado.nextLine();
				System.out.println("Consultar empleado por dni");
				String dni=teclado.nextLine();
				con=new EmpleadoController();
				con.buscarEmpleado(dni);
				
				break;
			case 3:
				System.out.println("Consulta de los que ganan a partir de...");
				System.out.println("Introduzca a partir de que cantidad mostrar empleados");
				double sal=teclado.nextDouble();
				con=new EmpleadoController();
				con.buscarEmpleadoPorSalario(sal);
				break;
			case 4:
				System.out.println("Consulta de los que ganan menos de...");
				System.out.println("Introduzca el maximo de salario para mostrar empleados");
				sal=teclado.nextDouble();
				con=new EmpleadoController();
				con.buscarEmpleadoPorSalarioInferior(sal);
				break;
			case 5:
				System.out.println("Nuevo empleado");
				teclado.nextLine();
				System.out.println("Introduzca el dni");
				String dn=teclado.nextLine();
				System.out.println("Introduzca nombre");
				String n=teclado.nextLine();
				System.out.println("Introduzca apellido");
				String ap=teclado.nextLine();
				System.out.println("Introduzca salario");
				double sa=teclado.nextDouble();
				System.out.println("Introduzca dpto al que pertenece");
				int dep=teclado.nextInt();
				Empleado em=new Empleado(dn,n,ap,sa,dep);
				System.out.println(em);
				EmpleadoController co=new EmpleadoController();
				co.insertarEmpleados(em);
			
				if(co.insertarEmpleados(em)==true) {
					System.out.println("Hecho");
				}else {
					System.out.println("Error");
				}
				
				break;
			case 6:
				teclado.nextLine();
				System.out.println("Modificacion de un empleado");
				System.out.println("Introduzca el dni del empleado que va a modificar");			
				String dniModificar=teclado.nextLine();
				Empleado emp=new Empleado();
				System.out.println("Introduzca el dni");
				dn=teclado.nextLine();
				emp.setDni(dn);
				System.out.println("Introduzca nombre");
				n=teclado.nextLine();
				emp.setNombre(n);
				System.out.println("Introduzca apellido");
				ap=teclado.nextLine();
				emp.setApellidos(ap);
				System.out.println("Introduzca salario");
				sa=teclado.nextDouble();
				emp.setSalario(sa);
				System.out.println("Introduzca dpto");
				dep=teclado.nextInt();
				emp.setDpto(dep);
				emp=new Empleado(dn,n,ap,sa,dep);
				System.out.println(emp);
				co=new EmpleadoController();
				co.modificarEmpleados(emp,dniModificar);
				
				if(co.insertarEmpleados(emp)==true) {
					System.out.println("Hecho");
				}else {
					System.out.println("Error");
				}
				break;
			case 7:
				System.out.println("Eliminacion de un empleado");
				teclado.nextLine();
				System.out.println("Introduzca el dni del empleado que va a borrar");			
				String dniBorrar=teclado.nextLine();
				co=new EmpleadoController();
				co.borrarEmpleados(dniBorrar);
				
				break;
			case 8:
				System.out.println("Mostrar los empleados de un departamento");
				System.out.println("Introduzca el departamento que va a mostrar los empleados");
				int d=teclado.nextInt();
				con=new EmpleadoController();
				con.mostrarEmpleadosPorDepartamento(d);
				break;
			case 9:
				System.out.println("Nuevo departamento");
				System.out.println("Introduzca ID");
				int id=teclado.nextInt();
				teclado.nextLine();
				System.out.println("Introduzca nombre del departamento");
				n=teclado.nextLine();
				Departamento depar=new Departamento(id,n);
				DepartamentoController dc=new DepartamentoController();
				if(dc.insertarDepartamento(depar)==true) {
					System.out.println("Hecho");
				}else {
					System.out.println("Error");
				}
				break;
			case 10:
				System.out.println("Modificacion de un departamento");
				System.out.println("Introduzca el id del departamento que va a modificar");			
				int idModificar=teclado.nextInt();
				Departamento departamento=new Departamento();
				System.out.println("Introduzca el id");
				id=teclado.nextInt();
				departamento.setId(id);
				teclado.nextLine();
				System.out.println("Introduzca nombre");
				n=teclado.nextLine();
				departamento.setNombre(n);
				departamento=new Departamento(id,n);
				System.out.println(departamento);
				dc=new DepartamentoController();
				dc.modificarDepartamento(departamento,idModificar);
				
				if(dc.modificarDepartamento(departamento,idModificar)==true) {
					System.out.println("Hecho");
				}else {
					System.out.println("Error");
				}
				break;
			case 11:
				System.out.println("Eliminacion de un departamento si no tiene empleados");
				System.out.println("Introduzca el ID del Departamneto que va a borrar");			
				int idBorrar=teclado.nextInt();
				dc=new DepartamentoController();
				dc.borrarDepartamento(idBorrar);
				break;
			case 12:
				System.out.println("Informacion de los departamentos");
				DepartamentoController deco=new DepartamentoController();
				deco.mostrarDepartamentos();
				break;
			case 13:
				System.out.println("Informacion de un departamento");
				System.out.println("Introduzca el ID del Departamneto que solicita informacion");
				id=teclado.nextInt();
				deco=new DepartamentoController();
				deco.informacionDepartamentoPorId(id);
				break;
			case 14:
				System.out.println("Informacion de un departamento");
				System.out.println("Introduzca el nombre del Departamneto que solicita informacion");
				teclado.nextLine();
				String nombre=teclado.nextLine();
				deco=new DepartamentoController();
				deco.informacionDepartamentoPorNombre(nombre);
				break;
			case 15:
				//como me crea 4 filas de cada empleado que creo en vez de 100 me suma 400
				System.out.println("Subida de salario");
				System.out.println("Introduzca el departamento que se subira el sueldo a los empleados");
				int num=teclado.nextInt();
				con=new EmpleadoController();
				con.subirSueldoMiembrosDepartamento(num);
				if(con.subirSueldoMiembrosDepartamento(num)==true) {
					System.out.println("Hecho");
				}else {
					System.out.println("Error");
				}
				break;
			case 16:
				System.out.println("Ha salido del programa, buen dia!");
				break;
			}
				
			
		}while(opcion!=16);
	}

}
