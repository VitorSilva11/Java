<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.List, br.com.study.modelo.Produto"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>    
 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Cadastro Produto</title>
	</head>
	<body>
	
		<p>Voltar para tela de cadastro: <a href = "entrada?acao=cadastroProduto">Cadastro de Produto</a> </p>	
		<h2>Lista de Produtos</h2>
		<ul>
			<c:forEach items="${listaProduto}" var = "produto">
				<li> 
				  Nome: ${produto.getNome()} || Descrição: ${produto.getDescricao()} || Preço: ${produto.getPreco()} 
				  || <a href = "entrada?acao=MostraProduto&id=${produto.getId()}">Editar</a> ||
				  <a href = "entrada?acao=RemoveProduto&id=${produto.getId()}">Remover</a>
				</li>
			
			</c:forEach>
		
		</ul>

	</body>
</html>