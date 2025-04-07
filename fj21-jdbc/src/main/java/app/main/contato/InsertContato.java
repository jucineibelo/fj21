package app.main.contato;

import dao.ContatoDao;
import model.Contato;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class InsertContato {
    public static void main(String[] args) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //Testando o DAO contato INSERT;
        Contato contatoTeste = new Contato();
        contatoTeste.setName("Ines");
        contatoTeste.setEmail("ines@example.com");
        contatoTeste.setEndereco("Rua Armando Marinho");

        //Campo data usei a API pra converter e ficar no padrão
        LocalDate hoje = LocalDate.now();
        String dataFormatada = dtf.format(hoje);
        contatoTeste.setDataNascimento(LocalDate.parse(dataFormatada, dtf));

        ContatoDao contatoDao = new ContatoDao();
        contatoDao.adicionaContato(contatoTeste);
        System.out.println("contato salvo com sucesso!");


    }
}
