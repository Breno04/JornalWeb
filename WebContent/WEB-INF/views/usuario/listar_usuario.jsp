<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		
		<c:forEach var="u" items="${usuarios}">
			
			<tr>
				<td>${u.usuarioId}</td>
				<td>${u.nomeCompleto}</td>
				<td>${u.login}</td>
				<td>${u.email}</td>
				<td> <a href="alterarUsuarioFormulario?usuId=${u.usuarioId}">Alterar</a></td>
				<td> <a href="apagarUsuario?id=${u.usuarioId}">Apagar</a></td>
				<td> <img alt="" src="<c:url value="/resources/imagem/${u.login}.png" />" /></td>
			</tr>
		
		</c:forEach>
	
	</table>

</body>
</html>