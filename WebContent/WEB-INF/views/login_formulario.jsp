<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/estilo.css">
<title>Insert title here</title>
</head>
<body>

<div class="header">
			<div class="linha">
				<div class="coluna col3">
					<h1 class="logo"><a href="/Jornal_Eletronico">Jornal</a></h1>
				</div>
				<div class="coluna col9">
					<ul class="menu inline sem-marcador">
						<li><a href="/Jornal_Eletronico">Home</a></li>
						<li><a href="mostrarMancheteClassificado">Classificados</a></li>
						<li><a href="listarSecao">Seções</a> 
						<li><a href="logout">Sair</a></li>
						
					</ul>
				</div>
			</div>
		</div>
		<br/>
		<br/>
		<br/>


<div class="coluna col3 sidebar">
	<p></p>					
</div>

<div class="contato coluna col10">
	<form action="login" method="post">
		Login: <input class="login" type="text" name="login"/> <br />
		Senha: <input  type="password" name="senha" /> <br />
		
	
		Tipo usuário:
		<select class="select" name="id">
			<c:forEach var="p" items="${papel}">
				<option value="${p.id}">${p.papel}</option>
			</c:forEach>
		</select> <br />
		
		<input class="botao" type="submit" value="ENTRAR" />
	</form>
	
</div>

</body>
</html>