package Desafio;
import java.sql.SQLException;
import java.util.Scanner;

public class CrudMain {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		CrudFuncoes cf = new CrudFuncoes();
		
		String nome, login, senha;
		int op, opcao, id;
		
		
		System.out.println("\n---------------------- BEM VINDO AO SISTEMA DE GERENCIAMENTO DE USUÁRIOS ----------------------\n");
		System.out.println("Selecione uma das opções abaixo:\n");
		System.out.println("1-Cadastrar  |  2-Consultar  |  3-Alterar  |  4-Excluir  |  5-Sair");
		System.out.printf("-> ");
		op = sc.nextInt();
		
		while ((op < 1) || (op > 5)) {
			System.out.println("Opção inválida, digite uma das opções acima:");
			System.out.printf("-> ");
			op = sc.nextInt();
		}
		
		while (op < 5) {			
		
			switch (op) {
			case 1:		// CADASTRAR
				System.out.printf("Digite o NOME do usuário: ");
				nome = sc.next();
				System.out.printf("Digite o EMAIL (será o login) desse usuário: ");
				login = sc.next();
				System.out.printf("Digite a SENHA inicial do usuário: ");
				senha = sc.next();
				cf.sqlINSERT(nome, login, senha);
				break;
				
			case 2: 	// CONSULTAR
				cf.sqlSELECT();
				break;
				
			case 3:		// ALETRAR
				System.out.println("Qual ID do user a ser alterado?");
				id = sc.nextInt();
				System.out.println("1-NOME  |  2-LOGIN  |  3-SENHA");
				opcao = sc.nextInt();
				System.out.println("Qual a nova informação?");
				String ntxt = sc.next();
				String txt;
				if (opcao == 1) {txt = "NOME";}
				else if (opcao == 2) {txt = "LOGIN";}
				else {txt = "SENHA";}
				cf.sqlUPDATE(txt, ntxt, id);			
				break;
				
			case 4:		// EXCLUIR
				System.out.println("Qual usuário deseja remover?");
				op = sc.nextInt();
				cf.sqlDELETE(op);
				break;
				
			case 5:		// FINALIZAR PROGRAMA
				System.out.println("\n Fechando programa...");
				break;		
			}
			
		System.out.println("\nDeseja outra operação? ( [1] [2] [3] [4] ou [5] para sair )");
		op = sc.nextInt();
		while ((op < 1) || (op > 5)) {
			System.out.println("Opção inválida, digite uma opção de 1 a 5:");
			System.out.printf("-> ");
			op = sc.nextInt();
		}
		}
		
		sc.close();

		System.out.println("Sistema finalizado!");

	}

}
