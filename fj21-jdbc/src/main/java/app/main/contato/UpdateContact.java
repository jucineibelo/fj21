package app.main.contato;

import dao.ContatoDao;
import model.Contato;

import java.time.LocalDate;

public class UpdateContact {
    public static void main(String[] args) {

        Contato contato = new Contato();
        contato.setId(4L);
        contato.setName("Isabelita");
        contato.setEmail("isa@gmail.com");
        contato.setEndereco("Rua Princesa Isabel");
        contato.setDataNascimento(LocalDate.now());

        ContatoDao contatoDao = new ContatoDao();
        contatoDao.updateContato(contato);
        System.out.println("update sucess");
    }
}
