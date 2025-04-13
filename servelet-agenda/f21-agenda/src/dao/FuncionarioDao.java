package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public List<Funcionario> getList() {
		String sql = "select * from funcionario";
		List<Funcionario> listaDeFuncionario = new ArrayList<>();

		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setId(rs.getLong("id"));
				funcionario.setName(rs.getString("name"));
				funcionario.setUsuario(rs.getString("usuario"));
				funcionario.setSenha(rs.getString("senha"));

				listaDeFuncionario.add(funcionario);
			}

			pstm.close();
			rs.close();

		} catch (SQLException e) {
			throw new RuntimeException();
		}

		return listaDeFuncionario;
	}

}
