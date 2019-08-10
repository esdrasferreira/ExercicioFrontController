

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
<link href="style.css" rel="stylesheet">
<title>Produtos</title>
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
	<c:catch var="usuario"></c:catch>
	<nav class="navbar navbar-expand-lg navbar-dark  bg-gradient-primary">

		<div class="container">
			<a class="navbar-brand  mb-0" href="#">Usuário logado:
				${usuario.usuario}</a>


		</div>
	</nav>









	<form action="atualizar-produto.html" method="post">
		<div class="container">
			<table class="table table-bordered table-dark">
				<thead class="thead-dark">
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Produto</th>
						<th scope="col">Imagem</th>
						<th scope="col">Link</th>
						<th scope="col">Alterar nome produto</th>
						<th scope="col">Excluir produto</th>
						<th scope="col">Adicionar</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="produto" items="${produtoList}">

						<tr>
							<td>${produto.id}</td>
							<td>${produto.produto}</td>
							<td>${produto.imagem}</td>
							<td><a href="verimagem-produto.html?idProduto=${produto.id}">Imagem</a></td>
							<td><a href="atualizar-produto.html?idProduto=${produto.id}">Atualizar</a>
							</td>
							<td><a href="excluir-produto.html?idProduto=${produto.id}">Excluir</a>
							</td>
							<td><a href="imagem-produto.html?idProduto=${produto.id}">Add
									imagem</a></td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
			
			<h6 style="color: white;">
			<c:if test="${numpagina != 1}">
			<a href="?numpagina=1">Primeira</a> &nbsp;
			</c:if>	
			
			<c:forEach begin="1" end="${numPaginas}" var="i">
					<c:choose>
						<c:when test="${numpagina eq i && numpagina != 1}">
			<a href="?numpagina=${i-1}"> Anterior </a> &nbsp;
			
			</c:when>
						<c:otherwise>
							
			</c:otherwise>
					</c:choose>


				</c:forEach>
			
			
			
			
				<c:forEach begin="1" end="${numPaginas}" var="i">
					<c:choose>
						<c:when test="${numpagina eq i}">
			${i}&nbsp;
			
			</c:when>
						<c:otherwise>
							<a href="?numpagina=${i}"> ${i} </a> &nbsp;
			</c:otherwise>
					</c:choose>


				</c:forEach>
				
				<c:forEach begin="1" end="${numPaginas}" var="i">
					<c:choose>
						<c:when test="${numpagina eq i && numpagina != numPaginas}">
			<a href="?numpagina=${i+1}"> Próxima </a> &nbsp;
			
			</c:when>
						<c:otherwise>
							
			</c:otherwise>
					</c:choose>


				</c:forEach>
				
			<c:if test="${numpagina != numPaginas}">
			<a href="?numpagina=${numPaginas}">Última</a> &nbsp;
			</c:if>	
			</h6>

		</div>
	</form>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>



</body>
</html>