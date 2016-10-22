<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "objeto.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Perfumadinho - Marcas Preferidas</title>
</head>
<body>
<img src="../img/logo_completa.png" height=65px>
<hr>
	<%
	Usuario u = (Usuario) session.getAttribute("usuario");
	if(u!= null){		
	%>
		<h1>Marcas Preferidas</h1>
	
		<%
		String escolhas[] = request.getParameterValues("marca");
		if(escolhas != null && escolhas.length != 0){
		%>
			<h3>Você escolheu:</h3>
			<ul>
			<%
			for(String s : escolhas) {
				%><li><%=s%></li>
			<%}%>
			</ul>
		<%}%>
		
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