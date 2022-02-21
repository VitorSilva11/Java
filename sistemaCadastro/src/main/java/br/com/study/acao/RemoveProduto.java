package br.com.study.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.study.dao.ProdutoDAO;
import br.com.study.factory.ConnectionFactory;

public class RemoveProduto implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		//Pegando id
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		//Crianco conexão com o banco de dados
		ConnectionFactory factory = new ConnectionFactory();
		try(Connection connection = factory.getConnection()){
			ProdutoDAO persistenciaProduto = new ProdutoDAO(connection);
			persistenciaProduto.remove(id);
		}
		
		
		return "redirect:entrada?acao=ListaProduto";
	}

}
