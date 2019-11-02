package Controller;
import java.sql.*;

import javax.naming.spi.DirStateFactory.Result;

import Modelo.Departamento;
import Modelo.Empleado;
public class EmpleadoController {
	public static Connection CreaConexion(){
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
				int dpto=rs.getInt("dpto");
					
				System.out.println("Dni "+nif+" Nombre: "+nombre+" Apellidos: "+apellido+" Salario: "+salario+" Dpto "+dpto);
			}
				
			miStatement.close();
			conec.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public boolean insertarEmpleados(Empleado e) {
		Connection c;
		c=CreaConexion();
		String dn=e.getDni();
		String no=e.getNombre();
		String ap=e.getApellidos();
		double sa=e.getSalario();
		int dep=e.getDpto();
		
		try {
			String insert= "insert into empleados values(?,?,?,?,?)";
			PreparedStatement p=c.prepareStatement(insert);
			p.setString(1, dn);
			p.setString(2, no);
			p.setString(3, ap);
			p.setDouble(4, sa);
			p.setInt(5, dep);
			
			int valor=p.executeUpdate();
			
			if(p.executeUpdate()==1) {
				System.out.println(1+" fila afectada");
				p.close();
				return true;
				
			}else {
				return false;
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;

	}
	
	
	
	public boolean modificarEmpleados(Empleado e,String dni) {
		Connection c=CreaConexion();
		String dn=e.getDni();
		String no=e.getNombre();
		String ap=e.getApellidos();
		double sa=e.getSalario();
		int dep=e.getDpto();
		
		try {
			String modificar= "update empleados set nif=?,nombre=?,apellidos=?,salario=?,dpto=? where empleados.nif="+dni;
			PreparedStatement ps=c.prepareStatement(modificar);
			ps.setString(1,dn);
			ps.setString(2,no);
			ps.setString(3,ap);
			ps.setDouble(4, sa);
			ps.setInt(5, dep);
			
			int v=ps.executeUpdate();
			
			if(ps.executeUpdate()>0) {
				System.out.println(v+" fila afectada");
				ps.close();
				return true;
				
			}else {
				return false;
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;

	}
	
	public void borrarEmpleados(String dni) {
		Connection c;
		c=CreaConexion();
		
		try {
			String sql = "delete from empleados where empleados.nif =?";
			PreparedStatement sentencia= c.prepareStatement (sql);
			sentencia.setString (1, dni);
			
			int valor=sentencia.executeUpdate();
			System.out.println(valor);
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public static void buscarEmpleado(String dni) {
		Connection conec;
		conec=CreaConexion();
		try {
			String sql = "select * from empleados where empleados.nif =?";
			PreparedStatement sentencia= conec.prepareStatement (sql);

			sentencia.setString (1, dni);
		
			ResultSet rs= sentencia.executeQuery();
			while(rs.next()) {
				String nif=rs.getString("nif");
				String nombre=rs.getString("nombre");
				String apellido=rs.getString("apellidos");
				Double salario=rs.getDouble("salario");
				int dep=rs.getInt("dpto");
						
				System.out.println("Dni "+nif+" Nombre: "+nombre+" Apellidos: "+apellido+" Salario: "+salario+" Dpto "+dep);
			}	
			System.out.println();
			sentencia.close();	
		}catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}

	
	public static void buscarEmpleadoPorSalario(double sa) {
		Connection conec;
		conec=CreaConexion();
		try {
			String sql = "select * from empleados where empleados.salario >=?";
			PreparedStatement sentencia= conec.prepareStatement (sql);

			sentencia.setDouble (1, sa);
		
			ResultSet rs= sentencia.executeQuery();
			while(rs.next()) {
				String nif=rs.getString("nif");
				String nombre=rs.getString("nombre");
				String apellido=rs.getString("apellidos");
				Double salario=rs.getDouble("salario");
				int dep=rs.getInt("dpto");
						
				System.out.println("Dni "+nif+" Nombre: "+nombre+" Apellidos: "+apellido+" Salario: "+salario+" Dpto "+dep);
			}	
			System.out.println();
			sentencia.close();	
		}catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
	}
	
	public static void buscarEmpleadoPorSalarioInferior(double sa) {
		Connection conec;
		conec=CreaConexion();
		try {
			String sql = "select * from empleados where empleados.salario <=?";
			PreparedStatement sentencia= conec.prepareStatement (sql);
			sentencia.setDouble (1, sa);

			ResultSet rs= sentencia.executeQuery();
			while(rs.next()) {
				String nif=rs.getString("nif");
				String nombre=rs.getString("nombre");
				String apellido=rs.getString("apellidos");
				Double salario=rs.getDouble("salario");
				int dep=rs.getInt("dpto");
						
				System.out.println("Dni "+nif+" Nombre: "+nombre+" Apellidos: "+apellido+" Salario: "+salario+" Dpto "+dep);
			}	
			System.out.println();
			
			sentencia.close();	
		}catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
	}
	
	public void mostrarEmpleadosPorDepartamento(int dpto) {
		Connection cone=CreaConexion();
		String sql="select * from empleados where empleados.dpto=?";
		try {
			PreparedStatement sen=cone.prepareStatement(sql);
			sen.setInt(1, dpto);
			ResultSet rs= sen.executeQuery();
			while(rs.next()) {
				String nif=rs.getString("nif");
				String nombre=rs.getString("nombre");
				String apellido=rs.getString("apellidos");
				Double salario=rs.getDouble("salario");
				int dep=rs.getInt("dpto");
						
				System.out.println("Dni "+nif+" Nombre: "+nombre+" Apellidos: "+apellido+" Salario: "+salario+" Dpto "+dep);
			}	
			System.out.println();
			sen.close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public boolean subirSueldoMiembrosDepartamento(int dep) {
		Connection cone=CreaConexion();
		String sql="update empleados set salario = salario +100 where empleados.dpto =?"; 
		
		try {
			PreparedStatement p=cone.prepareStatement(sql);
			p.setInt(1, dep);
			int valor=p.executeUpdate();
			
			if(p.executeUpdate()<0) {
				System.out.println(valor+" filas afectadas");
				p.close();
				return true;
				
			}else {
				return false;
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;

	}
	
	
}
