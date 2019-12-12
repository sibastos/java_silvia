<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Produtos</h1>
	<h5> Olá ${cliente.nome}</h5>

	<br />

	<fieldset>
		<legend>Produto</legend>

		<form action="cart?" method="get">
				<input type="hidden" name="action" id="action" value=add >
				<input type="hidden" name="clienteId" id="clienteId" value=${ cliente.id} >
				<input type="hidden" name="clienteNome" id="clienteNome" value=${ cliente.nome} >
				<input type="hidden" name="clienteCpf" id="clienteCpf" value=${ cliente.cpf} >
				<input type="hidden" name="clienteEnd" id="clienteEnd" value=${ cliente.endereco} >
				<input type="hidden" name="clienteEmail" id="clienteEmail" value=${ cliente.email} >
			
			<p>
				<label for="nome">Nome</label> 
				<input type="text" name="nome" id="nome" size="120">
			</p>

			<p>
				<label for="preco">Preço</label> 
				<input type="text" name="preco" id="preco" size="120">
			</p>
			
			<input  type="submit" value="Gravar">

		</form>


	</fieldset>
	
<div>
<!-- 	<form action="cart" method="post">
		<input type="hidden" name=clienteId value=${cliente.id}>
		<input type="submit" value="Finalizar compra">
	</form>   -->
	<a href="http://localhost:8080/jmsapp-web/send?cliente=${cliente.id}&total=${total}">Finalizar compra</a>
	<table class="" >
				<thead>
				</thead>
					<caption>Carrinho</caption>
					<tr>
						<th>Nome</th>
						<th>Preco</th>
						<th></th>
					</tr>
				<thead>
				<tbody>
					<c:forEach var="produto" items="${carrinho}" >
						<tr>
							
						  	<td>${produto.nome}</td>
						  	<td>${produto.preco}</td>
						  	<td><a href="<c:url value="cart?action=remove&produtoId=${produto.id}&clienteId=${cliente.id}"/>" > Remover </a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
</div>


</body>
</html>