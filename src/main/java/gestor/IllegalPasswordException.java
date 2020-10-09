package gestor;

public class IllegalPasswordException extends Exception {
    public IllegalPasswordException(String password, String message) {
        super("Illegal password " + password + ". " + message);
    }
}
