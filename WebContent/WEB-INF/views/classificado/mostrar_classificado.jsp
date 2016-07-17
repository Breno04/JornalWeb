<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/estilo.css">
	<link rel="stylesheet" type="text/css" href="resources/css/normalize.css">
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

	<c:forEach var="c" items="${classificado1}">
		<h1>${c.tituloClassificado}</h1>
		<h2>${c.textoClassificado}</h2> <br/>
		Preço inicial: <fmt:formatNumber value="${c.precoInicial}" type="currency"/> <br/><br/>
		Contato: ${c.telefone} <br/><br/>
		
		Maior oferta: <fmt:formatNumber value="${c.melhorOferta}" type="currency"/> <br/><br/>
		
		Data da ofeta: <fmt:formatDate value="${c.dataOferta}" pattern="dd/MM/yyyy HH:mm:ss"/><br /><br />
		
		Autor: ${c.nomeAutorOferta}<br/><br/>
				
		<c:if test="${usuario_leitor != null}">		
			<form action="inserirOferta" method="post">
		
				<input type="hidden" name="idClassificado" value="${c.classificadoId}"/>
				<input type="hidden" name="idUsuario" value="${usuario_leitor.usuarioId}" />
				<input type="text" name="melhorOferta"/>
				
			<input type="submit" value="Ofertar"/>
		
			</form>
		
		</c:if>
	</c:forEach>


</body>
</html>