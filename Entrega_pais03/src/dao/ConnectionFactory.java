package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Conectado ao banco de dados.");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

		public static Connection obtemConexao() throws SQLException {
			return DriverManager.getConnection("jdbc:mysql://localhost/usjt?useTimezone=true&serverTimezone=America/Sao_Paulo&user=root&password=&useSSL=false");
		}
}