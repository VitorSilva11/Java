package br.com.study.acao;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Acao {
	
	public abstract String executa(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException;

	
}
