package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entidad.Cliente;
import util.MysqlDBConexion;

public class ClienteModel {

	public int insertaCliente(Cliente obj){
		int salida = -1;
		
		Connection conn= null;
		PreparedStatement pstm = null;
		try {
			
			conn = MysqlDBConexion.getConexion();
			String sql ="insert into cliente values(null,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getApellido());
			pstm.setString(3, obj.getCorreo());
			pstm.setString(4, obj.getFechaNac());
			pstm.setString(5, obj.getDni());
			//La variable contiene el número de registros en la BD
			salida = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(pstm!= null) pstm.close();
				if(conn!= null) conn.close();
			} catch (Exception e2) {
			}
		}
		
		
		return salida;
	}
}
