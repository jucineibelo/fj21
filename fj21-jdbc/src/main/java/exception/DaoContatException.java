package exception;

public class DaoContatException extends RuntimeException {


    public DaoContatException(String message) {
        super(message);
    }

    public DaoContatException() {
        super("Erro ao adicionar contato");
    }

    public DaoContatException(String message, Throwable cause) {
        super(message, cause);
    }

}
