import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int op=0;
		int id1=0;
		String nome1 = null;
		Scanner tc= new Scanner(System.in);
		Pessoa p = new Pessoa();
		do{
			System.out.println("\n 1- Adicionar pessoa");
			System.out.println("\n 2- Mostrar pessoa por nome");
			System.out.println("\n 3- Mostrar pessoa por Id");
			System.out.println("\n 4- Remover pessoa por nome");
			System.out.println("\n 5- Remover pessoa por Id");
			System.out.println("\n 6- Atualizar por nome");
			System.out.println("\n 7- Listar todos");
			System.out.println("\n 8- quantidade de elementos no banco");
			System.out.println("\n 9- Sair");
			op = tc.nextInt();
			switch (op) {
			case 1:
				p.adicionar();;
				p.salvar();	
				break;
			case 2:
				System.out.println("Informe o nome:");
		        nome1=tc.next();
				Pessoa busca = new Pessoa();
				if(busca.getByNome(nome1)){
					System.out.println(busca.toString());
				}else{
					System.out.println("Não existe este nome");
				}
				break;
			case 3:
				System.out.println("Informe o ID:");
				id1=tc.nextInt();
				Pessoa busca1 = new Pessoa();
			     if(busca1.getById(7)){
			      	 System.out.println(busca1.toString()); 	  
			     }else{
			    	 	System.out.println("Não existe este id");
			     }
				break;
			case 4:
				System.out.println("Informe o nome:");
		        nome1=tc.next();
				Pessoa busca2= new Pessoa();
				if(busca2.getByNome(nome1)){
					busca2.remover();
				}else{
					System.out.println("Não existe este nome");
				}
				break;
			case 5:
				System.out.println("Informe o ID:");
				id1=tc.nextInt();
				Pessoa busca3= new Pessoa();
			     if(busca3.getById(7)){
			      	 busca3.remover();  
			     }else{
			    	 	System.out.println("Não existe este id");
			     }
				break;
			case 6:
				System.out.println("Informe o nome:");
		        nome1=tc.next();
				Pessoa busca4= new Pessoa();
				if(busca4.getByNome(nome1)){
					busca4.atualizar();
				}else{
					System.out.println("Não existe este nome");
				}
				break;
			case 7:
				Pessoa busca5 = new Pessoa();
				busca5.listar();
				break;
			case 8:
				Pessoa busca6 = new Pessoa();
				busca6.listar();
				break;
			default:
				System.out.println("Digito Inválido!");
				break;
			}
			
		}while(op!=9);
	
	}

}
