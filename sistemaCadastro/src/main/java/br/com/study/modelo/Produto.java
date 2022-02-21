package br.com.study.modelo;

public class Produto {
	
//Dados do produto	
	private int id;
	private String nome;
	private String descricao;
	private double preco;
	
	
//Construtor do produto
	public Produto(String nome, String descricao, double preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		
	}

	public Produto(int id, String nome, String descricao, double preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.id = id;
	}
	
	
//Getters e Setters
	//nome
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//descrição
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	//preço
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public double getPreco() {
		return preco;
	}
	
	//Id
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	

}
