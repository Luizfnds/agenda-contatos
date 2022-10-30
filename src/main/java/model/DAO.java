package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	/** Módulo de conexão **/
	
	// Parâmetros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda";
	private String user = "root";
	private String password = "3385";

	// Método de conexão
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
	
	public ArrayList<JavaBeans> listarContatos() {
		try {
			String read = "SELECT * FROM contatos ORDER BY nome";
			
			Connection con = conectar();
			PreparedStatement ps = con.prepareStatement(read);

			ArrayList<JavaBeans> contatos = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String telefone = rs.getString(3);
				String email = rs.getString(4);
				
				contatos.add(new JavaBeans(idcon , nome, telefone, email));
			}
			con.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null; 
		}
	}
}
