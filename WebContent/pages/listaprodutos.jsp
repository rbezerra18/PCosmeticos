<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "objeto.Usuario"%>
<%@ page import = "objeto.Produto"%>
<%@ page import = "model.ProdutoBD"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Perfumadinho - Lista de Produtos</title>
</head>
<body>
<img src="../img/logo_completa.png" height=65px>
<hr>
	<%
	Usuario u = (Usuario) session.getAttribute("usuario");
	if(u!= null){		
	%>
	
	<h1>Lista de Produtos</h1>
			
	<table border="1">
		<tr>
			<td>Código</td>
			<td>Descrição</td>
			<td>Quantidade</td>
			<td>Preço</td>
		</tr>
	
		<%ArrayList<Produto> listagem = (ArrayList<Produto>) ProdutoBD.listarProdutos();
		Iterator lit = listagem.iterator();
		float total=0;
		while(lit.hasNext())
		{
			Produto produtos2 = (Produto)lit.next();
		%>
		<tr>
			<td><%=produtos2.getCodigo()%></td>
			<td><%=produtos2.getDescricao()%></td>
			<td><%=produtos2.getQtd()%></td>
			<td><%=produtos2.getPreco()%></td>
		</tr>
	
		<%} %>	
	</table>
	<br>
	<form id="gerarPDF" action="../GerarPDFServlet" method="post">
		<input type="submit" title="Gerar PDF" value="Gerar PDF">
	</form>
	
	<%
	String aviso = (String) session.getAttribute("aviso3");
	if(aviso != null){
	%>
		<%=aviso %>
	<%}%>
	
	<br>
	<br>
	<form id="retornar" action="../RetornarServlet" method="post">
		<input type="submit" title="Retornar" value="Retornar">
	</form>
	<%}
	else response.sendRedirect("../index.jsp");
	%>
</body>
</html>