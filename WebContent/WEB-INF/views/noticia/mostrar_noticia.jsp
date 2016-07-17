<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="resources/css/estilo.css">
		<title>Notícias</title>
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
	
		<c:forEach var="n" items="${noticia}">
				
			<h3><a href="mostrarMancheteNoticia?idSecao=${n.secao.secaoId}">${n.secao.titulo}</a> </h3>
			
			Postado em: 
			<fmt:formatDate value="${n.dataNoticia}" pattern="dd/MM/yyyy HH:mm:ss"/> | Por: ${n.usuario.nomeCompleto} <br />
			
			<h1>${n.titulo}</h1> 
			<h2>${n.subtitulo}</h2>
			
			<p>${n.texto}</p>
			 
			<img alt="${n.titulo}" src="<c:url value="/resources/imagem/${n.titulo}.png" />" /><br />
			
			
			<c:if test="${usuario_editor != null}">
				<a href="apagarNoticia?idNoticia=${n.noticiaId}">apagar</a> <br />
			</c:if>
			<br />
			<c:if test="${usuario_leitor != null}"> 
				 <form action="inserirComentario"> 
				 	
				 	Comentário: <br /><br /><textarea rows="6" cols="50" name="texto"></textarea>
				 	<input name="idUsu" type="hidden" value="${usuario_leitor.usuarioId}" />
				 	<input name="idNoticia" type="hidden" value="${n.noticiaId}" />
				 	<input name="ativo" type="hidden" value="1"/>
				 	
				 	<input type="submit" value="Enviar" />
				 </form>
			</c:if>
			
			<br /><br />
			
			<h3>Comentários</h3>
			 
			<c:forEach var="c" items="${comentario}">
			 
			    ${c.usuario.nomeCompleto}: <strong> ${c.texto}</strong>
			 	 <br/>
			 	
			 	<c:if test="${c.usuario.usuarioId == usuario_leitor.usuarioId}">
			 		<a href="apagarComentario?idComentario=${c.id}&idNot=${n.noticiaId}">apagar</a>
			 	</c:if>
			 	
			</c:forEach>
		
		</c:forEach>
		
	</body>
</html>