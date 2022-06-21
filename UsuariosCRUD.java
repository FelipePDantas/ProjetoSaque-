import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuariosCRUD {
	static UsuarioDAO usuario = new UsuarioDAO();
	static Connection conexao = usuario.ConectaDB();
	
	public static void main(String[] args) {
		//criarusuarios("xatuba",5000,2000,9999); 
		//atualizarusuarios(5," Wagner Garcia Dantas", 5000, 2000, 5555);
		excluirusuaruios(10);
		//listausuarios(); 
	}

	public static void criarusuarios(String nome,int Ncartao ,int Saldo, int Senha) {
		try {
			//Integer.toString(Ncartao, Saldo);
			PreparedStatement prep = conexao.prepareStatement("INSERT INTO usuario (id,nome,Ncartao,Saldo,Senha) VALUES (null,?,?,?,?);");
			prep.setString(1, nome);
			prep.setInt(2, Ncartao);
			prep.setInt(3, Saldo);
			prep.setInt(4, Senha);
			prep.executeUpdate();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	public  ArrayList<Usuario> listausuarios() {
		ResultSet usuarios;
		ArrayList<Usuario>dados = new ArrayList<>() ;
		try {
			usuarios = conexao.createStatement()
					.executeQuery("SELECT * FROM usuario;");
			while(usuarios.next()) {
				Usuario user = new Usuario(usuarios.getInt("Ncartao"),usuarios.getInt("Saldo"),usuarios.getInt("id"),usuarios.getString("nome"),usuarios.getInt("senha"));
				dados.add(user);
				//System.out.println(usuarios.getInt("id") +"--"+usuarios.getString("nome")+ "--"+ usuarios.getInt("Ncartao") + "--"+ usuarios.getInt("Saldo")+"--"+usuarios.getInt("Senha"));
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dados;
				
		}
	public static void atualizarusuarios(int id ,String nome,int Ncartao ,int Saldo, int senha) {
		try {
			PreparedStatement prep = conexao.prepareStatement("UPDATE usuario SET nome = ?, Ncartao = ?, Saldo = ?, senha = ?  WHERE id = ? ");
			prep.setString(1, nome );
			prep.setInt(2, Ncartao);
			prep.setInt(3, Saldo);
			prep.setInt(4, senha);
			prep.setInt(5, id);
					
			prep.executeUpdate();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();}
	}
	public static void excluirusuaruios(int id) {
		try {
			PreparedStatement prep = conexao.prepareStatement("DELETE from usuario  WHERE id = ? ");
			prep.setInt(1, id);
					
			prep.executeUpdate();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();}
	}
	}	
	
	
	
	

