package br.com.study.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	
	public static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/sistema_cadastro?userTimezone=true&serverTimezone=UTC";
	private static  String usuario = "root";
	private static String senha = "V1t0r@2003";
	
	public static Connection getConnection() {
		
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, usuario, senha);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}catch(ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	

}
