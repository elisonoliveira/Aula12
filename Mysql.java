import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Mysql {
	public String url;
	public String usuario;
	public String senha;
	public Connection conexao=null;
	public String msg;
	public boolean con;
	
	public Mysql(){
		 this.url="jdbc:mysql://127.0.0.1:3306/algoritmos3";
		 this.usuario="root";
		 this.senha="1234";
		 this.conectar();
	}
	
	public Mysql(String u, String user, String pasw){
		
		this.url=u;
		this.usuario=user;
		this.senha=pasw;
		this.conectar();
	}
	
	public boolean conectar(){
		try {
			this.conexao = DriverManager.getConnection(this.url, this.usuario, this.senha);
			this.con = true;
			this.msg="Conectado";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			this.con=false;
			this.msg=e.getMessage();
			
		}
		return this.con;
		
	}
	
	public boolean desconectar(){
		try {
			this.conexao.close();
			return this.conexao.isClosed();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}


}
