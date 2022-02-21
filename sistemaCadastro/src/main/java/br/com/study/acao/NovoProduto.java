package br.com.study.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.study.dao.ProdutoDAO;
import br.com.study.factory.ConnectionFactory;
import br.com.study.modelo.Produto;

public class NovoProduto implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		//Pegando os dados do formulario
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String paramPreco = request.getParameter("preco");
		Double preco = Double.parseDouble(paramPreco);
		
		//Criando Produto
		Produto produto = new Produto(nome, descricao, preco);
		
		//Criando conexao com banco de dados
		ConnectionFactory factory = new ConnectionFactory();
		try(Connection connection = factory.getConnection()){
			ProdutoDAO persistenciaProduto = new ProdutoDAO(connection);
			persistenciaProduto.salva(produto);
		}
		
		
		return "forward:cadastroProduto.jsp";
	}

}
