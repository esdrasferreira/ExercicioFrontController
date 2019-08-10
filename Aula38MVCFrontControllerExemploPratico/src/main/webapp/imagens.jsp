<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Complete Bootstrap 4 Website Layout</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
	<link href="style.css" rel="stylesheet">
</head>
					
<body>
<nav
		class="navbar navbar-expand-lg navbar-dark  bg-gradient-primary mynav">

		<div class="container">
			<a class="navbar-brand h1 mb-0" href="listar-produto.html">Produtos</a>

			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSite">
				<span class="navbar-toggler-icon"></span>

			</button>

			<div class="collapse navbar-collapse" id="navbarSite">
				<ul class="navbar-nav mr-auto">

					<li class="nav-item"><a class="nav-link"
						href="add-produto.html">Adicionar Produtos</a></li>
					<li class="nav-item"><a class="nav-link"
						href="galeria-produto.html">Galeria de Imagens</a></li>



				</ul>

				<form action="procura-produto.html" method="get" class="form-inline">
					<input class="form-control ml-4 mr-2" name="produtoSearch"
						type="search" placeholder="Buscar...">
					<button class="btn btn-dark" type="submit">OK</button>
				</form>
				<form class="form-inline"></form>

				<form action="logout.html" class="form-inline ml-4 mr-2">

					<button class="btn btn-dark" type="submit">Logout</button>
				</form>

			</div>

		</div>
	</nav>
 
 	<c:catch var="produto"></c:catch>
 	<c:set var="caminho" value="${produto.imagem}"></c:set>


				
	<div class="container">
		<h1 class="my-4 text-center text-lg-left">Imagem</h1>
		<div class="row text-center text-lg-left">
			

			<div class="col-lg-3 col-md-4 col-xs-6">

				<img class="img-fluid img-thumbnail" src="${produto.imagem}">
				<address>${produto.imagem}</address>
			</div>

		
		
		</div>

	</div>







</body>

</html>