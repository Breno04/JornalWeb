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



<h2>Bem-Vindo, ${usuario_leitor.nomeCompleto}!</h2>

<a href="mostrarMancheteClassificado">Classificados</a> <br />
<a href="listarSecao"> Listar se��o</a>  <br />
<a href="logout"> Sair</a>  <br />

</body>
</html>