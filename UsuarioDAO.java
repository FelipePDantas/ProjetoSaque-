import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

	
	 public Connection ConectaDB() {
		 
		 Connection conexao = null;
		 
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/titulares","root","Tourinho38");
		
		 } catch (ClassNotFoundException e) {
			System.out.println ("Deu erro Major");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return conexao;
		
	}
}
