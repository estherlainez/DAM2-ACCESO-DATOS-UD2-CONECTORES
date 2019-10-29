package practica1;
import java.sql.*;
public class Controller {
	private Connection CreaConexion(){
		Connection conec=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//ordenador clase
			//conec=DriverManager.getConnection("jdbc:mysql://localhost/empresa","root","");
			//mi ordenador
			conec=DriverManager.getConnection("jdbc:mysql://localhost/empresa","root","12345678");
			//Statement senten=conec.createStatement();
			//String sql="select  * from empleados";
			//ResultSet resultado=senten.executeQuery(sql);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conec;
    }
	
	public void mostrarEmpleados() {
		Connection conec;
		try {
			conec=CreaConexion();
			//conec = DriverManager.getConnection("jdbc:mysql://localhost/empresa","root","12345678");
			Statement senten=conec.createStatement();
			String sql="select  * from empleados";
			ResultSet resultado=senten.executeQuery(sql);
			while(resultado.next()) {
				String nif=resultado.getString("nif");
				String nombre=resultado.getString("nombre");
				String apellido=resultado.getString("apellidos");
				Double salario=resultado.getDouble("salario");
				
				System.out.println("Dni "+nif+" Nombre: "+nombre+" Apellidos: "+apellido+" Salario: "+salario+" ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
