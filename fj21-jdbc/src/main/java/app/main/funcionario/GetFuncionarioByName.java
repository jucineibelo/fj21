package app.main.funcionario;

import dao.FuncionarioDao;
import model.Funcionario;

import java.util.Scanner;

public class GetFuncionarioByName {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Insira o nome do funcionario que deseja procurar: ");
        String name = sc.next();

        FuncionarioDao funcionarioDao = new FuncionarioDao();
        Funcionario funcionario = funcionarioDao.getByName(name);
        System.out.println(funcionario);
    }
}
