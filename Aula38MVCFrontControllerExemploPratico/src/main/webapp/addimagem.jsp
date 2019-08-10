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
	<title>Adicionar Produtos</title>
</head>

<body>

	<c:catch var="usuario"></c:catch>
	<c:catch var="produto"></c:catch>

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
				<ul class="navbar-nav ml-auto">
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" id="navDrop">Opções</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="add-produto.html">Adicionar Produto</a>
							<a class="dropdown-item" href="galeria-produto.html">Galeria de Imagens</a>
							<a class="dropdown-item" href="galeria-produto.html">Pesquisar produtos</a>




						</div>
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
	
	<nav class="navbar navbar-expand-lg navbar-dark  bg-gradient-primary">

		<div class="container">
			<a class="navbar-brand  mb-0" href="#">Usuário logado: ${usuario.usuario}  </a>
			<a class="navbar-brand  mb-0" href="#">Produto: ${produto.produto}</a>
			<a class="navbar-brand  mb-0" href="#">ID do produto: ${produto.id}</a>

		</div>
	</nav>





	




	</div>
	<div class="container">
		<form class="form-inline" action="upload.html?idProduto=${produto.id}" method="post"
			enctype="multipart/form-data">
			<div class="input-group mb-3">
				<div class="custom-file">

					<input type="file" name="upload" class="custom-file-input" id="inputGroupFile02"> <label
						class="custom-file-label" for="inputGroupFile02">Choose file</label>

				</div>
				<div class="input-group-append">
					<button class="btn btn-outline-secondary" type="submit">Enviar
						Imagem</button>

				</div>
			</div>
		</form>
	</div>




	<script>
		$('#inputGroupFile02').on('change', function () {
			//get the file name
			var fileName = $(this).val().replace('C:\\fakepath\\', " ");
			//replace the "Choose a file" label
			$(this).next('.custom-file-label').html(fileName);
		})
	</script>



</body>

</html>