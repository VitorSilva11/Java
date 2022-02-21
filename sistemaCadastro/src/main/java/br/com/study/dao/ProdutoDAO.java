package br.com.study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.study.modelo.Produto;

public class ProdutoDAO {
	
	
	
	private Connection connection;
	
	//Conexão com o banco de dados
	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}
	
	
	//Inserindo valor na tabela
	public void salva(Produto produto) throws SQLException {
		
		String sql = "INSERT INTO PRODUTO(NOME,DESCRICAO,PRECO) VALUES (?,?,?)";
		
		//Preperando o código sql, para nao haver nenhum sql-injection
		
		try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			pstm.setDouble(3, produto.getPreco());
			pstm.execute();
			
			//Pegando o id gerado para cada dado
			try(ResultSet rst = pstm.getGeneratedKeys()){
				while(rst.next()) {
				produto.setId(rst.getInt(1));
			   }

		    }
			
		
	    }

	 }
	
	//Retorna uma lista de produto
	public List<Produto> lista() throws SQLException{
		
		List<Produto> listaProduto = new ArrayList<>();
		String sql = "SELECT * FROM PRODUTO";
		
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.execute();
			
			try(ResultSet rst = pstm.getResultSet()){
				while(rst.next()) {
					Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDouble(4));	
					listaProduto.add(produto);
				}
			}
		}
		return listaProduto;
	}
	
	
	public Produto buscaPeloId(Integer id) throws SQLException {
		
		//Executando o código sql
		String sql = "SELECT * FROM PRODUTO WHERE ID = " + String.valueOf(id);
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.execute();
			
			//Pegando o resultado
			try(ResultSet rst = pstm.getResultSet()){
				while(rst.next()) {
					Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDouble(4));
					return produto;
				}
			}
		}
		return null;
		
		
	}
	
	public void altera(String nome, String descricao, double preco, Integer id) throws SQLException {
		
		String sql = "UPDATE PRODUTO SET NOME = '" + nome + "', DESCRICAO =  '" + descricao + "', PRECO = " + preco + " WHERE ID = " + id;
		
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.execute();
		}
		
	}
	
	public void remove(Integer id) throws SQLException {
		
		String sql = "DELETE FROM PRODUTO WHERE ID = " + id;
		
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.execute();
		}
	}
}
