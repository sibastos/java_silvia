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
				<label for="nome">Entre o seu id</label> 
				<input type="text" name="id" id="id" size="120">
			</p>

			
			<input  type="submit" value="Gravar">

		</form>


	</fieldset>


</body>
</html>