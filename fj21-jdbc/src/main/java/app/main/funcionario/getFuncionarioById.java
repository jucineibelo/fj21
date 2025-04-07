package app.main.funcionario;

import dao.FuncionarioDao;
import model.Funcionario;

import java.util.Scanner;

public class getFuncionarioById {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Insira o id do funcionario que deseja procurar: ");
        Long id = sc.nextLong();

        FuncionarioDao funcionarioDao = new FuncionarioDao();
        Funcionario funcionario = funcionarioDao.getById(id);
        System.out.println(funcionario);

    }
}
