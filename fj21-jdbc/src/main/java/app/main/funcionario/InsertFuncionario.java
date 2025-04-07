package app.main.funcionario;

import dao.FuncionarioDao;
import model.Funcionario;

public class InsertFuncionario {
    public static void main(String[] args) {

        Funcionario f1 = new Funcionario();
        f1.setName("Jucao");
        f1.setUsuario("jucz");
        f1.setSenha("324");

        FuncionarioDao funcionarioDao = new FuncionarioDao();
        funcionarioDao.insertFuncionario(f1);
        System.out.println("Funcionario criado com sucesso!");
    }
}
