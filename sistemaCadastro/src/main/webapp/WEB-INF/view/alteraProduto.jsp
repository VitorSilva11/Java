<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="br.com.study.modelo.Produto" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Alterar Dados</title>
	</head>
	<body>
	
		<h2>-- Alterar Dados --</h2>
		
		<form action = "entrada" method = "post">
		
			<label>Nome: </label> <input type = "text" name = "nome" value = "${produto.getNome()}"/>
			<label>Descrição: </label> <input type = "text" name = "descricao" value = "${produto.getDescricao()}"/>
			<label>Preço: </label> <input type = "number" name = "preco" value = "${produto.getPreco()}"/> 
			<input type = "hidden" name = "acao" value = "AlteraProduto" />
			<input type = "hidden" name = "id" value ="${produto.getId()}"/>
			
			<input type = "submit" value = "Alterar" />
		
		</form>

	</body>
</html>