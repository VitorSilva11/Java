package br.com.study.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.study.dao.ProdutoDAO;
import br.com.study.factory.ConnectionFactory;
import br.com.study.modelo.Produto;

public class ListaProduto implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		
		//Importando a blibioteca de Conexão
		ConnectionFactory factory = new ConnectionFactory();
		//Fazendo a conexão com o banco de dados
		try(Connection connection = factory.getConnection()){
			
			//Pegando a lista de produto registrado no banco de dados
			ProdutoDAO persistenciaProduto = new ProdutoDAO(connection); 
			List<Produto> listaProduto = persistenciaProduto.lista();
			
			//Enviando a requisição da lista de produto
			request.setAttribute("listaProduto", listaProduto);
			
			
		}
		
		
		return "forward:listaProduto.jsp";
	}

}
