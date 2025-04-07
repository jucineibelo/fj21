package app.main.funcionario;

import dao.FuncionarioDao;
import model.Funcionario;

public class UpdateFuncionario {
    public static void main(String[] args) {

        Funcionario funcionario = new Funcionario();
        funcionario.setId(5L);
        funcionario.setName("Teste update");
        funcionario.setUsuario("test");
        funcionario.setSenha("12345");

        FuncionarioDao funcionarioDao = new FuncionarioDao();
        funcionarioDao.updateFuncionario(funcionario);
        System.out.println("Updated with sucess");

    }
}
