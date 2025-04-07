package exception;

public class DaoFuncionarioException extends RuntimeException {


    public DaoFuncionarioException(String message) {
        super(message);
    }

    public DaoFuncionarioException() {
        super("Erro ao adicionar contato");
    }

    public DaoFuncionarioException(String message, Throwable cause) {
        super(message, cause);
    }

}
