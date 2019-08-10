
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
	<link href="style.css" rel="stylesheet">
<title>Produtos</title>
</head>
<body>

	<c:catch var="usuario"></c:catch>



	<nav class="navbar navbar-expand-lg navbar-dark  bg-gradient-primary">

		<div class="container">
			<a class="navbar-brand h1 mb-0" href="listar-produto.html">Produtos</a>

			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSite">
				<span class="navbar-toggler-icon"></span>

			</button>

			<div class="collapse navbar-collapse" id="navbarSite">
				<ul class="navbar-nav mr-auto">

					<li class="nav-item">
						<a class="nav-link" href="add-produto.html">Adicionar Produtos</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="galeria-produto.html">Galeria de Imagens</a>
					</li>



				</ul>
				
				<form action="procura-produto.html" method="get" class="form-inline">
					<input class="form-control ml-4 mr-2" name="produtoSearch" type="search" placeholder="Buscar...">
					<button class="btn btn-dark" type="submit">OK</button>
				</form>
				<form class="form-inline">


				</form>

				<form action="logout.html" class="form-inline ml-4 mr-2">

					<button class="btn btn-dark" type="submit">Logout</button>
				</form>

			</div>

		</div>
	</nav>
	

<div class="container">
	<nav class="navbar navbar-dark bg-dark">
		<div class="row">
			<div class="col" style="column-width: 10cm;">

			<form class="form-inline" action="update-produto.html" method="post">
				<input type="hidden" name="idProduto"
					value="${usuario.idproduto}">  <input
					class="form-control mr-sm-2" type="text" name="novoProduto"
					value="${usuario.produto}" style="background-color: white;"
					aria-label="Salvar">

				<button class="btn btn-outline-success my-2 my-sm-0"
					style="background-color: white;" type="submit">Salvar</button>
			</form></div>
		</div>
		
	</nav>
	</div>
	
	


	
	
	
	<div class="container">
	<label style="font-size: large; font-weight: bolder; color: red;">
	<%
			String erro = (String) request.getAttribute("erros");
			if (erro != null) {
				out.println(erro);
				out.println("<br>");
			}
		%>
	
	</label>
		
	</div>



	




</body>
</html>