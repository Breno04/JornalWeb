<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="alterarUsuario" method="post">
	
		<input type="hidden" name="usuId" value="${usuario.usuarioId}"/> <br/>
		<input type="text" name="nomeCompleto" value="${usuario.nomeCompleto}"/> <br/>
		<input type="text" name="login" value="${usuario.login}"/> <br/>
		<input type="text" name="senha" value="${usuario.senha}"/> <br/>
		<input type="text" name="email" value="${usuario.email}"/> <br/>
		
		<input type="submit" value="ALTERAR"/>
		
	</form>

</body>
</html>