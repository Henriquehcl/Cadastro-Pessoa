package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {

	// conection

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "0909";

	// Método de conexão - Conection method

	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);// pegando informação da linha 9 - get information with line 9
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;

		}
	}

	// create

	public void insertContato(JavaBeans contato) {
		String insert = "INSERT INTO contatos (nome, fone, email) VALUES (?,?,?)";
		try {
			// abrir a conexão - connection
			Connection con = conectar();

			// preparar a query para executar no DB
			PreparedStatement pst = con.prepareStatement(insert);

			// Substitui as interrogações pelo conteudo das variáveis
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());

			// execute
			pst.executeUpdate();

			// close connection
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	// Read//////
	
	//////

	public ArrayList<JavaBeans> listarContatos() {

		ArrayList<JavaBeans> contatos = new ArrayList<>();

		String read = "SELECT * FROM contatos ORDER BY nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);

				// ArrayList
				contatos.add(new JavaBeans(id, nome, fone, email));
			}
			con.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	//Update
	
	//selecionar contato - select contact
	public void selecionarContato(JavaBeans contato) {
		String readupdate = "SELECT * FROM contatos WHERE  id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(readupdate);
			pst.setString(1, contato.getId());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				//set variáveis JavaBeans
				contato.setId(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			//return null;
		}
	}
	
	//editar contato - edit contact
	public void alterarContato(JavaBeans contato) {
		String create = "UPDATE contatos SET nome=?, fone=?, email=? WHERE id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getId());
			
			//inserindo os valores abaixo, ocorre a atualização
			/*
			pst.setString(1, "Henrique Correa Lima");
			pst.setString(2, "666666666");
			pst.setString(3, "henrique@email.com");
			pst.setString(4, "1");
			*/
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			
		}
		
	}
	
	//DELETE - DELET
	
	public void deletarContato(JavaBeans contato) {
		String delete = "DELETE FROM contatos WHERE id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, contato.getId());
			pst.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	

	// test
	/*
	 * public void testeConexao() { try { Connection con = conectar();
	 * System.out.println(con); con.close(); } catch (Exception e) {
	 * System.out.println(e); } }
	 */

}
