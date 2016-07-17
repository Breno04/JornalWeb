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

<c:forEach var="n" items="${noticias1}">
		 	 <h1>${n.titulo}</h1> 
			 <h2>${n.subtitulo}</h2>
			 <p>${n.texto}</p>
			 Postado em: 
			 <fmt:formatDate value="${n.dataNoticia}" pattern="dd/MM/yyyy HH:mm:ss"/><br />
			 Por: ${n.usuario.nomeCompleto} <br />
			 ${n.secao.titulo} <br />
			 
			<img alt="${n.titulo}" src="<c:url value="/resources/imagem/${n.titulo}.png" />" /><br />
			
			<a href="apagarNoticia?idNoticia=${n.noticiaId}">apagar</a> <br />
			
			<c:if test="${usuario_leitor != null}"> 
				 <form action="inserirComentario"> 
				 	
				 	Comentário: <textarea rows="6" cols="50" name="texto"></textarea>
				 	<input name="idUsu" type="hidden" value="${usuario_leitor.usuarioId}" />
				 	<input name="idNoticia" type="hidden" value="${n.noticiaId}" />
				 	
				 	<input type="submit" value="Enviar" />
				 </form>
			</c:if>
			 
			<c:forEach var="c" items="${comentario}">
			 	${c.usuario.nomeCompleto} <br/>
			 	${c.texto} <br/>
			</c:forEach>
		
</c:forEach>



</body>
</html>