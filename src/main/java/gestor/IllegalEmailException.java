package gestor;

public class IllegalEmailException extends Exception {
    public IllegalEmailException(String email) {
        super("Illegal email: " + email + ".");
    }
}
