<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Perfumadinho Cosméticos</title>
</head>
<body>
<img src="img/logo_completa.png" height=65px>
<hr>
<h1>Gerenciamento de Cosméticos</h1>

	<form id="loginsenha" action="LoginServlet" method="post">
		<fieldset>
			<legend>Acesso ao sistema</legend>
				<br>
				<a title="Formulario para login"></a>
				<label for="login">Login:</label>
				<input type="text" name="login" id="login" placeholder="Login" required>
				<br>
				<br>
				<label for="senha">Senha:</label>
				<input type="password" name="senha" id="senha" placeholder="Senha" required>
				<br>
				<br>
			<input type="submit" title="Entrar" value="Entrar">
		</fieldset>
	</form>
<%
String aviso = (String) session.getAttribute("aviso0");
if(aviso != null){
%>
<%=aviso %>
<%}
session.invalidate();
%>
	<br>
	<br>
	<form id="cadusuario" action="CadastrarServlet" method="GET">
			<input type="submit" title="Cadastrar Usuário" value="Novo Usuário">
	</form>	

</body>
</html>