package model;

import java.sql.DriverManager;
import com.mysql.jdbc.Connection;

public class ConexaoBD {

	private Connection con;
	
	public void iniciaBd(){
		try{	
		    String database = "jdbc:mysql://db4free.net:3306/perfumadinho";
		    String usuario = "perfumadinho";
			String senha = "admin2016";		
	        Class.forName("com.mysql.jdbc.Driver"); 
	        con = (Connection) DriverManager.getConnection( database, usuario, senha );
		} catch ( Exception e ) {
			e.printStackTrace();
     }		
	}
	
	public void fechaBd(){
		try{
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConexao()
	{	
		return con;		
	}
}