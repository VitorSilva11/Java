package br.com.study.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.study.dao.ProdutoDAO;
import br.com.study.factory.ConnectionFactory;

public class AlteraProduto implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		//Pegando os dados
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String paramPreco = request.getParameter("preco");
		String paramId = request.getParameter("id");
		
		
		double preco = Double.valueOf(paramPreco);
		Integer id = Integer.valueOf(paramId);
		
		
		//Criando conexão com banco de dados
		ConnectionFactory factory = new ConnectionFactory();
		try(Connection connection = factory.getConnection()){
			ProdutoDAO persistenciaProduto = new ProdutoDAO(connection);
			persistenciaProduto.altera(nome, descricao, preco, id);
		}
		
		
		return "redirect:entrada?acao=ListaProduto";
	}

}
