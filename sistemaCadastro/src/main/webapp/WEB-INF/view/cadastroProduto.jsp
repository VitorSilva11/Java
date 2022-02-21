<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Cadastro Produto</title>
	</head>
	<body>
		
		<form action = "entrada" method = "post">
			
			<h2>Cadastro Produto</h2>
			<label name = "nome" >Nome:</label> <input type = "text" name = "nome" />
			<label name = "descricao">Descrição:</label> <input type = "text" name = "descricao" />
			<label>Preço:</label> <input type = "number" name = "preco" />
			<input type = "hidden" name = "acao" value = "NovoProduto" />
			<input type = "submit" value = "Cadastrar" class = "enviar"/>
			<a href = "entrada?acao=ListaProduto">ListarProduto</a>
		
		</form>
		
		
	</body>
</html>