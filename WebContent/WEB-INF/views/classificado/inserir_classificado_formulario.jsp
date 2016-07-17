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

<form class="cl" action="inserirClassificado" method="post">
<br/>
	Título:<br/>
	<input type="text" name="tituloClassificado"/> <br/><br/>
	Texto:<br/>
	<input type="text" name="textoClassificado"/> <br/><br/>
	Preço inicial:<br/>
	<input type="text" name="precoInicial"/> <br/><br/>
	Telefone:<br/>
	<input type="text" name="telefone"/> <br/><br/>
	
	<input type="hidden" name="usuId" value="${usuario_editor.usuarioId}" />
	
	<input type="hidden" name="melhorOferta" value="0"/>
	
	<input type="submit" value="INSERIR"/>
</form>

</body>
</html>