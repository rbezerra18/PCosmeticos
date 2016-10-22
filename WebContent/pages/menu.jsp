<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "objeto.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Perfumadinho - Menu</title>
</head>
<body>
<img src="../img/logo_completa.png" height=65px>
<hr>
	<%
	Usuario u = (Usuario) session.getAttribute("usuario");
	if(u!= null){		
	%>
	<h1>Menu</h1>
	
	<form id="addproduto" action="../CadastrarProdutoServlet" method="GET">
			<input type="submit" title="Cadastrar Produto" value="Cadastrar Produto">
	</form>
	<br>
	<form id="edtproduto" action="../EdtProdutoServlet" method="post">
			<input type="submit" title="Alterar Produto" value="Alterar Produto">
	</form>
	<br>
	<form id="delproduto" action="../CadastrarProdutoServlet" method="post">
			<input type="submit" title="Deletar Produto" value="Deletar Produto">
	</form>
	<br>
	<form id="listarprodutos" action="../ListarProdutosServlet" method="post">
			<input type="submit" title="Listar Produtos" value="Listar Produtos">
	</form>
	<br>
	<form id="escolhermarcas" action="../MarcasServlet" method="post">
			<input type="submit" title="Escolher Marcas" value="Escolher Marcas">
	</form>
	<br>	
	<form id="sair" action="../SairServlet" method="post">
		<input type="submit" title="Sair do Sistema" value="Sair">
	</form>
	<%}
	else response.sendRedirect("../index.jsp");
	%>
</body>
</html>