package Desafio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {
	
	public Statement conectarDB() throws SQLException {
		try {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/ctt?useTimezone=true&serverTimezone=UTC", "root", "1602");
		Statement st = conn.createStatement();
		return st;
		}
		catch(SQLException e) {
			System.out.println("Erro de conexão: " + e.getMessage());
			return null;
		}		
	}

}
