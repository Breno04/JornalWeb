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
						<li><a href="listarSecao">Se��es</a> 
						<li><a href="logout">Sair</a></li>
						
					</ul>
				</div>
			</div>
		</div>
		
		<div class="acoes">
	 	<div class="coluna">
	 		<ul class="menu inline sem-marcador ss">
	 			<li>Bem-Vindo, ${usuario_editor.nomeCompleto}!</li>
	 			<li><a href="cadastrarSecaoFormulario"> Cadastrar se��o</a></li>
	 			<li><a href="cadastrarJornalistaFormulario"> Cadastrar Jornalista</a></li>
	 			<li><a href="inserirClassificadoFormulario">Cadastrar classificado</a></li>
	 			<li><a href="listarUsuario">Listar usu�rio</a></li>
	 		</ul>
	 	</div>
	 </div>
	
	<!-- 
		<h2>Bem-Vindo, ${usuario_editor.nomeCompleto}!</h2>
	
		<a href="cadastrarJornalistaFormulario"> Cadastrar Jornalista</a> <br />
		
		<a href="cadastrarSecaoFormulario"> Cadastrar se��o</a> <br />
		<a href="listarSecao"> Listar se��o</a>  <br />
		
	 -->
	 
	 
	</body>
</html>