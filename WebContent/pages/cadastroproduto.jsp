<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "objeto.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Perfumadinho - Cadastro de Produto</title>
</head>
<body>
<img src="../img/logo_completa.png" height=65px>
<hr>
	<%
	Usuario u = (Usuario) session.getAttribute("usuario");
	if(u!= null){		
	%>
	<h1>Cadastro de Produto</h1>
	
	<form id="cadproduto" action="../CadastrarProdutoServlet" method="post">
		<fieldset>
				<a title="Formulario para cadastro"></a>
				<label for="cod">Código:</label>
				<input type="text" name="cod" id="cod" placeholder="Código" required>
				<br>
				<br>
				<label for="descricao">Descrição:</label>
				<input type="text" name="descricao" id="descricao" placeholder="Descrição" required>
				<br>
				<br>
				<label for="qtd">Quantidade:</label>
				<input type="text" name="qtd" id="qtd" placeholder="Quantidade" required>
				<br>
				<br>
				<label for="preco">Preço Unitário:</label>
				<input type="text" name="preco" id="preco" placeholder="Preço Unitário" required>
				<br>
				<br>				
				<input type="submit" title="Cadastrar" value="Cadastrar">
		</fieldset>
	</form>
	<%
	String aviso = (String) session.getAttribute("aviso2");
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