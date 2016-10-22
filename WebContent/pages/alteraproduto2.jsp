<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "objeto.Usuario"%>
<%@ page import = "objeto.Produto"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Perfumadinho - Alteração de Produto</title>
</head>
<body>
<img src="../img/logo_completa.png" height=65px>
<hr>
	<%
	Usuario u = (Usuario) session.getAttribute("usuario");
	Produto p = (Produto) session.getAttribute("produto");
	if(u!= null){		
	%>
	<h1>Alteração de Produto</h1>
	
	<form id="edtproduto2" action="../EdtProdutoServlet2" method="post">
		<fieldset>
				<a title="Formulario para alteração"></a>
				<label for="cod">Código:</label>
				<input type="text" name="cod" id="cod" value="<%=p.getCodigo()%>" required>
				<br>
				<br>
				<label for="descricao">Descrição:</label>
				<input type="text" name="descricao" id="descricao" value="<%=p.getDescricao()%>" required>
				<br>
				<br>
				<label for="qtd">Quantidade:</label>
				<input type="text" name="qtd" id="qtd" value="<%=p.getQtd()%>" required>
				<br>
				<br>
				<label for="preco">Preço Unitário:</label>
				<input type="text" name="preco" id="preco" value="<%=p.getPreco()%>" required>
				<br>
				<br>				
				<input type="submit" title="Alterar" value="Alterar">
		</fieldset>
	</form>
	<%
	String aviso = (String) session.getAttribute("aviso");
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