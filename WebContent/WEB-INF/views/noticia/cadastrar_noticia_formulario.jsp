<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/estilo.css">
	<link rel="stylesheet" type="text/css" href="resources/css/normalize.css">
<title>Cadastro de notícia</title>
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
		<script type="text/javascript" src="resources/ckeditor/ckeditor.js"></script>
		
		<form action="cadastrarNoticia" method="post" enctype="multipart/form-data">
		
			Título:<br/> <input type="text" name="titulo"/> <br /><br />
			Subtítulo:<br/> <input type="text" name="subtitulo"/> <br /><br />
			Texto: <br/><textarea id="text" rows="5" cols="100" name="texto"></textarea> <br /><br />
			Imagem:<br/> <input type="file" name="imagem"/> <br />
					<input type="hidden" name="ativo" value="1"/>
		
		<script type="text/javascript">//<![CDATA[
        CKEDITOR.replace('text');
//]]></script><br />
		
			<input name="usuario_id" type="hidden" value="${usuario_jornalista.usuarioId}" />
			
			Seção da notícia:
			<select name="secao_id">
				<c:forEach var="s" items="${secao}">
					<option value="${s.secaoId}">${s.titulo}</option>
				</c:forEach>
			</select> <br /><br />
		
			<input type="submit" value="Cadastrar"/>
		</form>
		
	
	</body>
</html>