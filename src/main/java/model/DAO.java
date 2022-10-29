package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAO {
	/** M�dulo de conex�o **/
	
	// Par�metros de conex�o
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda";
	private String user = "root";
	private String password = "3385";

	// M�todo de conex�o
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
	
	public void testaConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void insert(JavaBeans contato) {
		try {
			String create = "INSERT INTO contatos (nome, telefone, email) VALUES (?,?,?)";
			
			Connection con = conectar();
			PreparedStatement ps = con.prepareStatement(create);
					
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getTelefone());
			ps.setString(3, contato.getEmail());
			
			ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		} 
		
	}
}
