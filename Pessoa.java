import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Pessoa {
	public int id;
	public String nome;
	public int idade;
	public static int qtd;
	
	Scanner tc = new Scanner(System.in);
	
	 public void ler(){
		 this.nome="ramon";
		 this.idade=30;
	 }
	 
	 public void adicionar(){
		 String n =  null;
		 System.out.println("Informe o nome que quer adicionar:");
		 n=tc.next();
		 this.nome=n;
	 }
	
	 public boolean atualizar(){
		 return false;
	 }
	
	 public void remover(){
		 
		
	 }
	 
	 public void listar(){
		 System.out.println("Existem "+ qtd + "Elementos.");
	 }
	 
	 public static ArrayList<Pessoa> getAll(){
		 Mysql m = new Mysql();
		 ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
		 
		 try {
			 String sql= "SELECT * FROM pessoa;";
			 PreparedStatement comandoSql= m.conexao.prepareStatement(sql);
			 
			 ResultSet rs =comandoSql.executeQuery();
			 while (rs.next()) {
				 Pessoa p = new Pessoa();
				 p.id= rs.getInt("id");
				 p.nome= rs.getString("nome");		
				 p.idade = rs.getInt("idade");
				 lista.add(p);
				 qtd++;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			m.msg = e.getMessage();
			return null;
		}
		 return lista;
		 
	 }
	 
	 public boolean getById(int id){
		 Mysql m = new Mysql();
		 
		 try {
			 String sql= "SELECT * FROM pessoa WHERE id=?;";
			 PreparedStatement comandoSql= m.conexao.prepareStatement(sql);
			 comandoSql.setInt(1,id);
			 ResultSet rs =comandoSql.executeQuery();
			 while (rs.next()) {
				 this.id= rs.getInt("id");
				 this.nome= rs.getString("nome");		
				 this.idade = rs.getInt("idade");
				 return true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			m.msg = e.getMessage();
			return false;
		}
		 return false;
		 
	 }
	 
	 public boolean getByNome(String nome){
	 Mysql m = new Mysql();
		 
		 try {
			 String sql= "SELECT * FROM pessoa WHERE nome=?;";
			 PreparedStatement comandoSql= m.conexao.prepareStatement(sql);
			 comandoSql.setString(1, nome);
			 ResultSet rs =comandoSql.executeQuery();
			 while (rs.next()) {
				 this.id= rs.getInt("id");
				 this.nome= rs.getString("nome");		
				 this.idade = rs.getInt("idade");
				 return true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			m.msg = e.getMessage();
			return false;
		}
		 return false;
	 }
	
	public boolean salvar(){
		Mysql m = new Mysql();
		try{
	
            		
			String sql= "INSERT INTO pessoa (nome,idade)VALUES(?,?);";
			PreparedStatement comandoSQL = m.conexao.prepareStatement(sql);
			
			comandoSQL.setString(1,this.nome);
			comandoSQL.setInt(2, this.idade);
			comandoSQL.execute();
			comandoSQL.close();
			return true;
		}catch (SQLException e){
			e.printStackTrace();
			m.msg = e.getMessage();
			return false;
				
		}
	}
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + "]";
	}

}
