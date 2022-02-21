package br.com.study.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.study.acao.Acao;



@WebServlet(urlPatterns = "/entrada")
public class Controle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//pegando a biblioteca da classe(A classe precisa ter o mesmo nome da acao)
		String paramAcao = request.getParameter("acao");
		String nomeDaClasse = "br.com.study.acao." + paramAcao;
		String nome;
		
		try {
			Class classe = Class.forName(nomeDaClasse);//Carregando a classe
			//Instaciando a classe
			Acao acao = (Acao) classe.newInstance();
			//Executando o método
			nome = acao.executa(request, response);
		}catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e){
			throw new ServletException(e);
		}
		
		String tipoEndereco[] = nome.split(":");
		
		if(tipoEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
			rd.forward(request, response);
		}else {
			response.sendRedirect(tipoEndereco[1]);
		}
		
		
	}

}
