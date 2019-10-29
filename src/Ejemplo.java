import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.*;



public class Ejemplo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//ordenador clase
			//Connection conec=DriverManager.getConnection("jdbc:mysql://localhost/empresa","root","");
			//mi ordenador
			Connection conec=DriverManager.getConnection("jdbc:mysql://localhost/empresa","root","12345678");
			Statement senten=conec.createStatement();
			String sql="select  * from empleados";
			ResultSet resultado=senten.executeQuery(sql);
			
			while(resultado.next()) {
				String nif=resultado.getString("nif");
				String nombre=resultado.getString("nombre");
				String apellido=resultado.getString("apellidos");
				Double salario=resultado.getDouble("salario");
				
				System.out.println(nif+" "+nombre+" "+apellido+" "+salario+" ");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
