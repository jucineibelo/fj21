package app.main.contato;

import dao.ContatoDao;
import model.Contato;

import java.util.List;

public class GetAllContatos {
    public static void main(String[] args) {

        //Testando o getContatoList
        ContatoDao contatoDao = new ContatoDao();
        List<Contato> contatos = contatoDao.getContatosList();

        for (Contato contato : contatos) {
            System.out.println("Nome:	" + contato.getName());
            System.out.println("Email:	" + contato.getEmail());
            System.out.println("Endereço:	" + contato.getEndereco());
            System.out.println("Data de	Nascimento:	" + contato.getDataNascimento().toString() + "\n");
        }
    }
}
