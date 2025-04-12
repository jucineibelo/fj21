package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import factory.ConnectionFactory;
import model.Funcionario;

public class FuncionarioDao {
	
	private Connection connection;

	public FuncionarioDao() {
		this.connection = new ConnectionFactory().getConnection();
	}


	public void adicionaFuncionario(Funcionario funcionario) {
		String sql = "insert into funcionario(name, usuario, senha) values(?, ?, ?) ";

		try {
			
			PreparedStatement pstm = this.connection.prepareStatement(sql);
			pstm.setString(1, funcionario.getName());
			pstm.setString(2, funcionario.getUsuario());
			pstm.setString(3, funcionario.getSenha());
			pstm.execute();
			pstm.close();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
