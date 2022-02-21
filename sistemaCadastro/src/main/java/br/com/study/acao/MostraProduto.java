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

public class MostraProduto implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		
		//Pegando o parametro ID
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		//Importando Conexão do banco de dados
		ConnectionFactory factory = new ConnectionFactory();
		
		//Criando uma conexão com o banco de dados.
		try(Connection connection = factory.getConnection()){
			
			ProdutoDAO persistenciaProduto = new ProdutoDAO(connection);
			
			Produto produto = persistenciaProduto.buscaPeloId(id);
			
			request.setAttribute("produto", produto);
			
		}
		
		
		return "forward:alteraProduto.jsp";
	}
	
	
	
	

}
