package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import factory.ConnectionFactory;
import model.Contato;

public class ContatoDao {
	
	private Connection connection;
	
	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adicionaContato(Contato contato) {
		String sql = "insert into contato(name, endereco, data_nascimento) values(?, ?, ?) ";
		
		try {
			
			PreparedStatement pstm = this.connection.prepareStatement(sql);
			pstm.setString(1, contato.getName());
			pstm.setString(2, contato.getEndereco());
			pstm.setString(3, contato.getDataNascimento().toString());
			pstm.execute();
			pstm.close();
		} catch (SQLException e ) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
