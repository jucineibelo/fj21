package dao;

import exception.DaoContatException;
import factory.ConnectionFactory;
import model.Contato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContatoDao {

    private Connection connection;

    public ContatoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adicionaContato(Contato contato) {
        String sql = "insert into contats (name, email, endereco, data_nascimento) " +
                "values(?, ?, ?, ?) ";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, contato.getName());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setDate(4, Date.valueOf(contato.getDataNascimento()));
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new DaoContatException(e.getMessage());
        }
    }

    public List<Contato> getContatosList() {
        String sql = "select * from contats";
        try {
            List<Contato> contatos = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Contato contato = new Contato();
                contato.setId(rs.getLong("id"));
                contato.setName(rs.getString("name"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));
                contato.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());

                contatos.add(contato);
            }

            rs.close();
            stmt.close();
            return contatos;

        } catch (SQLException e) {
            throw new DaoContatException("Erro ao executar query " + e);
        }
    }

    public Contato getById(Long id) {
        String sql = "select * from contats where id= ?";

        try {
            PreparedStatement pstm = this.connection.prepareStatement(sql);
            pstm.setLong(1, id);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                Contato contato = new Contato();
                contato.setId(rs.getLong("id"));
                contato.setName(rs.getString("name"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));
                contato.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                rs.close();
                pstm.close();

                return contato;
            } else {
                throw new DaoContatException(id + " não encontrado");
            }
        } catch (SQLException e) {
            throw new DaoContatException();
        }
    }

    public Contato getByName(String name) {
        String sql = "select * from contats where name like ?";

        try {
            PreparedStatement pstm = this.connection.prepareStatement(sql);
            pstm.setString(1, "%" + name + "%");
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                Contato contato = new Contato();
                contato.setId(rs.getLong("id"));
                contato.setName(rs.getString("name"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));
                contato.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                rs.close();
                pstm.close();
                return contato;
            } else {
                throw new DaoContatException("Contato com nome " + name + " não encontrado.");
            }
        } catch (SQLException e) {
            throw new DaoContatException("Erro ao buscar contato por nome: " + name, e);
        }
    }

    public void updateContato(Contato contato) {
        String sql = "update contats set name = ?, email = ?, endereco = ?, data_nascimento = ? where id = ? ";

        try {
            PreparedStatement pstm = this.connection.prepareStatement(sql);
            pstm.setString(1, contato.getName());
            pstm.setString(2, contato.getEmail());
            pstm.setString(3, contato.getEndereco());

            if (contato.getDataNascimento() == null) {
                throw new IllegalArgumentException("Data não pode ser nula. by juca");
            }

            pstm.setDate(4, Date.valueOf(contato.getDataNascimento()));
            pstm.setLong(5, contato.getId());
            pstm.executeUpdate();
            pstm.close();

        } catch (SQLException e) {
            throw new DaoContatException("Erro ao atualizar contato " + e);
        }
    }

    public void deleteContato(Long id) {
        String sql = "delete from contats where id = ?";

        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setLong(1, id);
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            throw new DaoContatException("Erro ao excluir contato " + id);
        }
    }

}
