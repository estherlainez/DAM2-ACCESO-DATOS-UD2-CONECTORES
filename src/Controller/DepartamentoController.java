package Controller;

import java.sql.*;

import Modelo.Departamento;
import Modelo.Empleado;
import Controller.EmpleadoController;

public class DepartamentoController {
	
	public boolean insertarDepartamento(Departamento depar) {
		Connection c=EmpleadoController.CreaConexion();
		int id=depar.getId();
		String no=depar.getNombre();
		
		try {
			String insert= "insert into departamentos values(?,?)";
			PreparedStatement ps=c.prepareStatement(insert);
			ps.setInt(1, id);
			ps.setString(2, no);
			
			int valor=ps.executeUpdate();
			
			if(ps.executeUpdate()>0) {
				System.out.println(valor+" fila afectada");
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

	public boolean modificarDepartamento(Departamento depar, int idM) {
		Connection c=EmpleadoController.CreaConexion();
		int id=depar.getId();
		String no=depar.getNombre();
		
		try {
			String modificar= "update departamentos set ID=?,nombre=? where departamentos.ID="+idM;
			PreparedStatement ps=c.prepareStatement(modificar);
			ps.setInt(1,id);
			ps.setString(2,no);
			
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
	
	
	public void mostrarDepartamentos() {
		Connection c=EmpleadoController.CreaConexion();
		String sql="select * from departamentos";
		try {
			Statement st=c.createStatement();
			ResultSet rs=st.executeQuery(sql);
				
			while(rs.next()) {
				int de=rs.getInt("ID");
				String nombre=rs.getString("nombre");
					
				System.out.println("ID "+de+" Nombre: "+nombre);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public void informacionDepartamentoPorID(int id) {
		Connection conexion=EmpleadoController.CreaConexion();
		String sql="select * from departamentos where departamentos.ID=?";
		try {
			PreparedStatement sentencia=conexion.prepareStatement(sql);
			sentencia.setInt(1, id);
			ResultSet resul=sentencia.executeQuery();
			while(resul.next()) {
				int ID=resul.getInt("ID");
				String nombre=resul.getString("nombre");
				System.out.println("ID "+ID+" Nombre: "+nombre);
			}
			System.out.println();
			sentencia.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void informacionDepartamentoPorNombre(String n) {
		Connection conexion=EmpleadoController.CreaConexion();
		String sql="select * from departamentos where departamentos.nombre=?";
		try {
			PreparedStatement sentencia=conexion.prepareStatement(sql);
			sentencia.setString(1, n);
			ResultSet resul=sentencia.executeQuery();
			while(resul.next()) {
				int ID=resul.getInt("ID");
				String nombre=resul.getString("nombre");
				System.out.println("ID "+ID+" Nombre: "+nombre);
			}
			System.out.println();
			sentencia.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void borrarDepartamento(int  idBorrar) {
		Connection c=EmpleadoController.CreaConexion();
		
		try {
			String sql = "delete from departamentos where departamentos.ID =?";
			PreparedStatement sentencia= c.prepareStatement (sql);
			sentencia.setInt (1, idBorrar);
			
			int valor=sentencia.executeUpdate();
			System.out.println(valor);
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	
	
	
}
