package Desafio;

import java.sql.SQLException;
import org.junit.Assert;
import org.junit.Test;
public class TestesJUnit {
	
	
	CrudFuncoes cf = new CrudFuncoes();
	BD bd = new BD();
	
	// ESSE SIMPLES TESTE VALIDA TODOS MÉTODOS DO CRUD.
	@Test
	public void cRUD() {
		Assert.assertEquals("OK", cf.getValida());
	}
	
	// ESSE VALIDA A CONEXÃO COM O BANCO.
	@Test
	public void bANCO() throws SQLException {
		Assert.assertNotNull(bd.conectarDB());
	}


	
}
