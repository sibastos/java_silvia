<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Vendas</h1>
	<h5>${mensagem}</h5>
	<br />

	<fieldset>
		<legend>Login</legend>

		<form action="cliente" method="get">
			<p>
				<label for="nome">Nome</label> 
				<input type="text" name="nome" id="nome" size="120">
			</p>

			<p>
				<label for="email">email</label> 
				<input type="text" name="email" id="emial" size="120">
			</p>
			
			<p>
				<label for="cpf">cpf</label> 
				<input type="text" name="cpf" id="cpf" size="120">
			</p>
			
			<p>
				<label for="endereco">endereco</label> 
				<input type="text" name="endereco" id="endereco" size="120">
			</p>
			
			<input  type="submit" value="Gravar">

		</form>


	</fieldset>


</body>
</html>