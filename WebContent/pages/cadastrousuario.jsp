<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "objeto.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Perfumadinho - Cadastro de Usuário</title>
</head>
<body>
<img src="../img/logo_completa.png" height=65px>
<hr>
	<h1>Cadastro de Usuário</h1>
	
	<form id="cadastrousuario" action="../CadastrarServlet" method="post">
		<fieldset>
				<a title="Formulario para cadastro"></a>
				<label for="cpf">CPF:</label>
				<input type="text" name="cpf" id="cpf" placeholder="CPF" required>
				<br>
				<br>
				<label for="nome">Nome:</label>
				<input type="text" name="nome" id="nome" placeholder="Nome" required>
				<br>
				<br>
				<label for="login">Login:</label>
				<input type="text" name="login" id="login" placeholder="Login" required>
				<br>
				<br>
				<label for="senha">Senha:</label>
				<input type="password" name="senha" id="senha" placeholder="Senha" required>
				<br>
				<br>				
				<input type="submit" title="Cadastrar" value="Cadastrar">
		</fieldset>
	</form>
<%
String aviso = (String) session.getAttribute("aviso1");
if(aviso != null){
%>
<%=aviso %>
<%}
session.invalidate();
%>
	<br>
	<br>
	<form id="sair" action="../SairServlet" method="post">
		<input type="submit" title="Sair do Cadastro" value="Sair">
	</form>	

	
</body>
</html>