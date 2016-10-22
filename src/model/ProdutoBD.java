package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import objeto.Produto;

public class ProdutoBD {
		
	static public synchronized boolean addProduto(Produto p)
	{
		try{			
		ConexaoBD a = new ConexaoBD();
		a.iniciaBd();
		Connection c = a.getConexao();
		PreparedStatement ps = (PreparedStatement) c.prepareStatement("INSERT INTO produtos (codigo, descricao, qtd, preco) Values (?,?,?,?)"); 
		ps.setString(1,p.getCodigo());
		ps.setString(2,p.getDescricao());
		ps.setString(3,p.getQtd());
		ps.setString(4,p.getPreco());
		
		System.out.println(p.getCodigo()+p.getDescricao()+p.getQtd()+p.getPreco());
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
	
	static public synchronized boolean edtProduto(Produto p)
	{		
		try{			
		ConexaoBD a = new ConexaoBD();
		a.iniciaBd();
		Connection c = a.getConexao();
		PreparedStatement ps = (PreparedStatement) c.prepareStatement("UPDATE produtos SET descricao = ?, qtd=?, preco=? WHERE codigo = ?"); 
		ps.setString(1,p.getDescricao());
		ps.setString(2,p.getQtd());
		ps.setString(3,p.getPreco());
		ps.setString(4,p.getCodigo());
		
		System.out.println(p.getCodigo()+p.getDescricao()+p.getQtd()+p.getPreco());
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
	
	static public synchronized boolean delProduto(Produto p)
	{
		try{			
		ConexaoBD a = new ConexaoBD();
		a.iniciaBd();
		Connection c = a.getConexao();
		PreparedStatement ps = (PreparedStatement) c.prepareStatement("DELETE FROM produtos (codigo, descricao, qtd, preco) Values (?,?,?,?) WHERE codigo = ?"); 
		ps.setString(1,p.getCodigo());
		ps.setString(2,p.getDescricao());
		ps.setString(3,p.getQtd());
		ps.setString(4,p.getPreco());
		ps.setString(5,p.getCodigo());		
		
		System.out.println(p.getCodigo()+p.getDescricao()+p.getQtd()+p.getPreco());
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
	
	public static ArrayList<Produto> listarProdutos()
	{
		ArrayList<Produto> produtoList = new ArrayList<Produto>();		
		try
	    {  
		   ConexaoBD conb = new ConexaoBD();
		   conb.iniciaBd();
		   Connection con = conb.getConexao();
		   PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * from produtos order by descricao"); 
		   ResultSet res =  (ResultSet) ps.executeQuery();
		   while(res.next())
		   {
			   Produto p = new Produto(res.getString("codigo"),res.getString("descricao"),res.getString("qtd"),res.getString("preco"));
			   produtoList.add(p);
			   
		   }
		   ps.close();
		   con.close();
		   conb.fechaBd();
	}
		catch(Exception e)
		{
			produtoList = null;
		}		
		
		return produtoList;
	}
	
	public static Produto buscarProduto(Produto p)
	{
		Produto produto = new Produto();
		try
	    {  
		   ConexaoBD conb = new ConexaoBD();
		   conb.iniciaBd();
		   Connection con = conb.getConexao();
		   PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT codigo, descricao, qtd, preco FROM produtos WHERE codigo = ?");
		   ps.setString(1,p.getCodigo());
		   ResultSet res =  (ResultSet) ps.executeQuery();
		   produto.setCodigo(res.getString("codigo"));
		   produto.setDescricao(res.getString("descricao"));
		   produto.setQtd(res.getString("qtd"));
		   produto.setPreco(res.getString("preço"));
		   ps.close();
		   con.close();
		   conb.fechaBd();
	    }
		catch(Exception e)
		{
			produto = null;
		}		
		
		return produto;
	}	
		
}