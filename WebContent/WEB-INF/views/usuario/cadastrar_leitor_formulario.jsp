<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="cadastrarUsuarioLeitor" method="post">
	
		Nome:
		<input type="text" name="nomeCompleto"/> <br />
		Login:
		<input type="text" name="login"/> <br />
		Senha:
		<input type="password" name="senha"/> <br />
		Email:
		<input type="text" name="email"/> <br />
		
		<input type="hidden" name="ativo" value="1"/>
		
		<input type="submit" value="ENVIAR">
	</form>

</body>
</html>