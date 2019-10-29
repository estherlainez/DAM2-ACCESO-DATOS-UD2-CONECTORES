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
			//conec=DriverManager.getConnection("jdbc:mysql://localhost/empresa","root","12345678");
			//otra con true autoReconected en mi ordenador
			conec= DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa?autoReconnect=true&useSSL=false",
					"root","12345678");
			
			
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
			Statement miStatement=conec.createStatement();
				
			String sql="select  * from empleados";
			ResultSet rs = miStatement.executeQuery(sql);
				
			while(rs.next()) {
				String nif=rs.getString("nif");
				String nombre=rs.getString("nombre");
				String apellido=rs.getString("apellidos");
				Double salario=rs.getDouble("salario");
					
				System.out.println("Dni "+nif+" Nombre: "+nombre+" Apellidos: "+apellido+" Salario: "+salario+" ");
			}
				
			miStatement.close();
			conec.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
