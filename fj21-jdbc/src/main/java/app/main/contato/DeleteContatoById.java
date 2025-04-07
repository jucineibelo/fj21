package app.main.contato;

import dao.ContatoDao;

public class DeleteContatoById {
    public static void main(String[] args) {
        ContatoDao contatoDao = new ContatoDao();
        contatoDao.deleteContato(3L);
        System.out.println("Contato deletado com sucesso!");
    }
}
