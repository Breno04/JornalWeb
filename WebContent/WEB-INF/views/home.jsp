<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="resources/css/estilo.css">
	<link rel="stylesheet" type="text/css" href="resources/css/normalize.css">
	<title>Home</title>
</head>
	<body>
		<div class="header">
			<div class="linha">
				<div class="coluna col3">
					<h1 class="logo"><a href="/Jornal_Eletronico">Jornal</a></h1>
				</div>
				<div class="coluna col9">
					<ul class="menu inline sem-marcador menu1">
						<li><a href="/Jornal_Eletronico">Home</a></li>
						
						<c:if test="${usuario_leitor == null}">
							<li><a href="cadastrarLeitorFormulario">Cadastre-se</a></li>
							<li><a href="loginFormulario">Logar</a></li>
						</c:if>
						
						<li><a href="listarSecao">Seções</a> </li>
						<li><a href="mostrarMancheteClassificado">Classificados</a></li>
							
						<c:if test="${usuario_leitor != null}">
							<a href="logout">Sair</a>
						</c:if>
						
						<c:if test="${usuario_editor != null}">
							<a href="logout">Sair</a>
						</c:if>
							
						<c:if test="${usuario_jornalista != null}">
							<a href="logout">Sair</a>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
		
	<c:if test="${usuario_editor != null}">
										
		 <div class="acoes">
		 	<div class="coluna">
		 		<ul class="menu inline sem-marcador">
		 			<li>Bem-Vindo, ${usuario_editor.nomeCompleto}!</li>
		 			<li><a href="cadastrarSecaoFormulario"> Cadastrar seção</a></li>
		 			<li><a href="cadastrarJornalistaFormulario"> Cadastrar Jornalista</a></li>
		 			<li><a href="inserirClassificadoFormulario">Cadastrar classificado</a></li>
		 		</ul>
		 	</div>
		 </div>
	</c:if>
	
	<c:if test="${usuario_jornalista != null}">
										
		 <div class="acoes">
		 	<div class="coluna">
		 		<ul class="menu inline sem-marcador">
		 			<li>Bem-Vindo, ${usuario_jornalista.nomeCompleto}!</li>
	 			<li><a href="cadastrarNoticiaFormulario"> Cadastrar Noticia</a></li>
	 			<li><a href="mostrarNoticiaJornalista?usuarioId=${usuario_jornalista.usuarioId}"> Minhas notícias</a></li>
		 		</ul>
		 	</div>
		 </div>
	</c:if>

	<div class="linha">
		<div class=" coluna col7">
		<h3>Destaques</h3>
			<c:forEach var="n" items="${destaques}">
			
				${n.titulo} <br />
				<img alt="${n.titulo}" src="<c:url value="/resources/imagem/${n.titulo}.png" />" /> <br />
				<a href="mostrarNoticia?idNoticia=${n.noticiaId}">Leia mais &raquo;</a>
			</c:forEach>
		</div>
	
	<h3>Últimas notícias</h3>
		<c:forEach var="n" items="${recentes}">
			<div class="coluna col5">
				<ul class="sem-marcador sem-padding noticias">
					<li>
						${n.titulo} <a href="mostrarNoticia?idNoticia=${n.noticiaId}">Leia mais &raquo;</a>
						<img alt="${n.titulo}" src="<c:url value="/resources/imagem/${n.titulo}.png" />" />
					</li>
				</ul>
			</div>
		</c:forEach>
		
	</div>

<!-- 	
	<div class="linha">
		<c:forEach var="c" items="${claRecentes}">
			<div class="coluna col4">
				${c.tituloClassificado} <br/>
				${c.textoClassificado} <br/>
				${c.precoInicial}
			</div>
		</c:forEach>
	</div>
	 -->
	 
		

</body>
</html>