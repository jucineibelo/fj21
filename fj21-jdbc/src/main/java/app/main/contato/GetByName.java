package app.main.contato;

import dao.ContatoDao;
import model.Contato;

public class GetByName {
    public static void main(String[] args) {

        //Testando getByName
        ContatoDao contatoDao = new ContatoDao();
        Contato getByname = contatoDao.getByName("Ines");

        System.out.println(getByname);
    }

}
