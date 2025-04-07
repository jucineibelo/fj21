package app.main.funcionario;

import dao.FuncionarioDao;
import model.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class getAllFuncionarios {
    public static void main(String[] args) {

        List<Funcionario> list = new ArrayList<>();

        FuncionarioDao funcionarioDao = new FuncionarioDao();
        list = funcionarioDao.getAllFuncionarios();

        System.out.println(list);
    }
}
