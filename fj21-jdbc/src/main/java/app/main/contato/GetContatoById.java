package app.main.contato;

import dao.ContatoDao;
import model.Contato;

public class GetContatoById {
    public static void main(String[] args) {

        //Testando getById
        ContatoDao contatoDao = new ContatoDao();
        Contato getByidContato = contatoDao.getById(1L);

        System.out.println(getByidContato);
    }
}
