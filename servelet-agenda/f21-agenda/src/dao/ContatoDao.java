package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.DateFormatter;

import factory.ConnectionFactory;
import model.Contato;

public class ContatoDao {

	private Connection connection;

	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adicionaContato(Contato contato) {
		String sql = "insert into contato(name, endereco, data_nascimento, email) values(?, ?, ?, ?) ";

		try {

			PreparedStatement pstm = this.connection.prepareStatement(sql);
			pstm.setString(1, contato.getName());
			pstm.setString(2, contato.getEndereco());
			pstm.setString(3, contato.getDataNascimento().toString());
			pstm.setString(4, contato.getEmail());
			pstm.execute();
			pstm.close();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public List<Contato> getLista() {
		List<Contato> listaDeContatos = new ArrayList<>();
		String sql = "select * from contato";

		try {
			PreparedStatement pstm = this.connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setName(rs.getString("name"));			
				contato.setDataNascimento(rs.getTimestamp("data_nascimento").toLocalDateTime());
				contato.setEndereco(rs.getString("endereco"));
				contato.setEmail(rs.getString("email"));
				listaDeContatos.add(contato);
			}

			rs.close();
			pstm.close();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}

		return listaDeContatos;
	}

}
