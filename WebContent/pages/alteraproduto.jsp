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
				<a title="Informe o código do produto"></a>
				<label for="cod">Código:</label>
				<input type="text" name="cod" id="cod" placeholder="Código" required>
				<br>
				<br>						
				<input type="submit" title="Buscar" value="Buscar">
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