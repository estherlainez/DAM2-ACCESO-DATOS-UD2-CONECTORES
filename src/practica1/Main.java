package practica1;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado=new Scanner(System.in);
		System.out.println("MENU");
		System.out.println("1.Consultar todos los empleados");
		System.out.println("2.Consultar empleados por dni");
		System.out.println("3.Consultar por saldo mayor a.....");
		System.out.println("4.Consultar por salario igual o inferior a....");
		int opcion=teclado.nextInt();
		do {
			switch(opcion) {
			case 1:
				Controller a=new Controller();
				a.mostrarEmpleados();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				System.out.println("Salir");
				break;
			}
				
			
		}while(opcion!=5);
	}

}
