package Desafio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudFuncoes {
	
	BD bd = new BD();
	private String valida = "OK";
		
	public void sqlSELECT() throws SQLException{
		try {			
				Statement state = bd.conectarDB();
				state.executeQuery("SELECT * FROM USUARIO");		
				ResultSet set = state.getResultSet();
				
				while (set.next()) {
					System.out.printf("%d: %15s \t %15s \t %15s \t %15s\n",
							set.getInt("id"),
							set.getString("nome"),
							set.getString("login"),
							set.getString("senha"),
							set.getString("dt_cad"));
			}
			state.close();
			
			}catch (Exception e) {
				valida = e.getMessage();
				System.out.println("Erro: " + valida);
			}
	}
// -----------------------------------------------------------	
	
	public void sqlINSERT(String nome, String login, String senha) throws SQLException{		
		try {
			Statement state = bd.conectarDB();		
			state.executeUpdate("INSERT INTO USUARIO (nome, login, senha) VALUES (\""+ nome + "\", \"" + login + "\", \"" +  senha + "\")");		
			state.close();	
			System.out.println("Dados inseridos com sucesso!!");
		}
		catch(SQLException e) {
			valida = e.getMessage();
			System.out.println("Erro no INSERT dos dados: " + valida);
		}		
	}	// O INSERT NÃO TEM DATA POIS EU COLOQUEI UMA TRIGGER NA TABELA DO BANCO PARA ADICIONAR UM SYSDATE NA INSERÇÃO DOS DADOS.
// -----------------------------------------------------------	
	
	public void sqlUPDATE(String column, String newValue, int id) throws SQLException{
		try {
			Statement state = bd.conectarDB();			
			state.executeUpdate("UPDATE USUARIO SET " + column + " = \"" + newValue + "\" WHERE ID = " + id);			
			state.close();	
			System.out.println("Dados atualizados com sucesso!!");
		}catch(SQLException e) {
			valida = e.getMessage();
			System.out.println("Erro no UPDATE dos dados: " + valida);
		}	
	}
// -----------------------------------------------------------	
	
	public void sqlDELETE(int id) throws SQLException{
		try {
			Statement state = bd.conectarDB();			
			state.executeUpdate("DELETE FROM USUARIO WHERE ID = " + id);			
			state.close();	
			System.out.println("Dados deletados com sucesso!!");
		}catch(SQLException e) {
			valida = e.getMessage();
			System.out.println("Erro no DELETE dos dados: " + valida);
		}	
	}
	
	public String getValida() {
		return valida;
	}
}
