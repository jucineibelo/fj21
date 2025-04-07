package app.main.funcionario;

import dao.FuncionarioDao;

public class DeleteFuncionario {
    public static void main(String[] args) {

        FuncionarioDao funcionarioDao = new FuncionarioDao();
        funcionarioDao.deleteFuncionario(6L);
        System.out.println("Funcionario deletado com sucesso");
    }
}
