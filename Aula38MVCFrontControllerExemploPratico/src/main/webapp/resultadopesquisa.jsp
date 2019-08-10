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
<title>Produtos Encontrados</title>
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
               
                 <form  action="logout.html"   class="form-inline ml-4 mr-2">
                    
                    <button class="btn btn-dark" type="submit">Logout</button>
                </form>
				
            </div>

        </div>
    </nav>
    <c:catch var="usuario"></c:catch>
    <nav class="navbar navbar-expand-lg navbar-dark  bg-gradient-primary">

        <div class="container">
            <a class="navbar-brand  mb-0" href="#">Usuário logado:	${usuario.usuario}</a>
                     

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
						<th scope="col">link</th>
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
						<td><a
							href="verimagem-produto.html?idProduto=${produto.id}">link</a></td>
						<td><a
							href="atualizar-produto.html?idProduto=${produto.id}">Atualizar</a>
						</td>
						<td><a
							href="excluir-produto.html?idProduto=${produto.id}">Excluir</a>
						</td>
						<td>
						<a
							href="imagem-produto.html?idProduto=${produto.id}">Add imagem</a>
						</td>
					</tr>
				
					</c:forEach>



			</tbody>
		</table>
		
	</div>
</form>
	


</body>
</html>