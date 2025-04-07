package dao;

import exception.DaoFuncionarioException;
import factory.ConnectionFactory;
import model.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {

    private Connection connection;

    public FuncionarioDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void insertFuncionario(Funcionario funcionario) {

        String sql = "insert into funcionario (name, usuario, senha) values (?, ?, ?) ";

        try {
            PreparedStatement pstm = this.connection.prepareStatement(sql);
            pstm.setString(1, funcionario.getName());
            pstm.setString(2, funcionario.getUsuario());
            pstm.setString(3, funcionario.getSenha());
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            throw new DaoFuncionarioException(e.getMessage());
        }
    }

    public List<Funcionario> getAllFuncionarios() {
        String sql = "select * from funcionario";

        try {
            List<Funcionario> listaDeFuncionarios = new ArrayList<>();
            PreparedStatement pstm = this.connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getLong("id"));
                funcionario.setName(rs.getString("name"));
                funcionario.setUsuario(rs.getString("usuario"));
                funcionario.setSenha(rs.getString("senha"));

                listaDeFuncionarios.add(funcionario);
            }

            rs.close();
            pstm.close();
            return listaDeFuncionarios;

        } catch (SQLException e) {
            throw new DaoFuncionarioException("Erro ao listar funcionarios " + e.getMessage());
        }
    }

    public Funcionario getById(Long id) {
        String sql = "select * from funcionario where id = ?";

        try {
            PreparedStatement pstm = this.connection.prepareStatement(sql);
            pstm.setLong(1, id);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getLong("id"));
                funcionario.setName(rs.getString("name"));
                funcionario.setUsuario(rs.getString("usuario"));
                funcionario.setSenha(rs.getString("senha"));
                rs.close();
                pstm.close();

                return funcionario;
            } else {
                throw new DaoFuncionarioException(id + " não encontrado");
            }
        } catch (SQLException e) {
            throw new DaoFuncionarioException();
        }
    }

    public Funcionario getByName(String name) {
        String sql = "select * from funcionario where name like ?";

        try {
            PreparedStatement pstm = this.connection.prepareStatement(sql);
            pstm.setString(1, "%" + name + "%");
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getLong("id"));
                funcionario.setName(rs.getString("name"));
                funcionario.setUsuario(rs.getString("usuario"));
                funcionario.setSenha(rs.getString("senha"));
                rs.close();
                pstm.close();

                return funcionario;
            } else {
                throw new DaoFuncionarioException(name + " não encontrado");
            }
        } catch (SQLException e) {
            throw new DaoFuncionarioException("Nome não encontrado " + e.getMessage());
        }
    }

    public void updateFuncionario(Funcionario funcionario){

        String sql = "update funcionario set name = ?, usuario = ?, senha = ? where id = ?";

        try {
            PreparedStatement pstm = this.connection.prepareStatement(sql);
            pstm.setString(1, funcionario.getName());
            pstm.setString(2, funcionario.getUsuario());
            pstm.setString(3, funcionario.getSenha());
            pstm.setLong(4, funcionario.getId());
            pstm.executeUpdate();
            pstm.close();

        } catch (SQLException e){
            throw new DaoFuncionarioException("Erro ao atualizar " + e.getMessage());
        }
    }

    public void deleteFuncionario(Long id) {
        String sql = "delete from funcionario where id = ?";

        try {
            PreparedStatement pstm = this.connection.prepareStatement(sql);
            pstm.setLong(1, id);
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            throw new DaoFuncionarioException("Erro ao deletar " + id);
        }
    }


}
