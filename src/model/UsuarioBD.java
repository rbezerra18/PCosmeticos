package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import objeto.Usuario;

public class UsuarioBD {
	public static Usuario logar(String login,String senha)
	{
		try
	    {  
		   ConexaoBD conb = new ConexaoBD();
		   conb.iniciaBd();
		   Connection con = conb.getConexao();
		   PreparedStatement st = (PreparedStatement) con.prepareStatement("SELECT * from usuarios where login=? and senha=?");
		   st.setString(1, login);
		   st.setString(2, senha);
		   ResultSet res = (ResultSet) st.executeQuery();
		   res.next();
		   Usuario u = new Usuario(res.getString("cpf"),res.getString("nome"),res.getString("login"),res.getString("senha"));
		   return u;		   
	    }
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		  		
	}
	
	static public synchronized boolean addUsuario(Usuario u)
	{
		try{
			
		ConexaoBD a = new ConexaoBD();
		a.iniciaBd();
		Connection c = a.getConexao();
		PreparedStatement ps = (PreparedStatement) c.prepareStatement("INSERT INTO usuarios (cpf, nome, login, senha) Values (?,?,?,?)"); 
		ps.setString(1,u.getCpf());
		ps.setString(2,u.getNome());
		ps.setString(3,u.getLogin());
		ps.setString(4,u.getSenha());
		
		ps.executeUpdate();
		ps.close();
		c.close();
		a.fechaBd();
	    return true;
	    }
		    catch ( Exception e ) {
	           e.printStackTrace();
			   return false;
		      }
		}
	
	public static ArrayList<Usuario> listarUsuarios ()
	{
		ArrayList<Usuario> usuarioList = new ArrayList<Usuario>();
		
		try
	    {  
		   ConexaoBD conb = new ConexaoBD();
		   conb.iniciaBd();
		   Connection con = conb.getConexao();
		   PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * from usuarios order by login"); 
		   ResultSet res =  (ResultSet) ps.executeQuery();
		   while(res.next())
		   {
			   Usuario u = new Usuario(res.getString("cpf"),res.getString("nome"),res.getString("login"),res.getString("senha"));
			   usuarioList.add(u);
			   
		   }
		   ps.close();
		   con.close();
		   conb.fechaBd();
	}
		catch(Exception e)
		{
			usuarioList = null;
		}
		
		
		return usuarioList;
	}
		
}
