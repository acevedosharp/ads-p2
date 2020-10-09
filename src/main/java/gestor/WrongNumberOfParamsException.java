package gestor;

public class WrongNumberOfParamsException extends Exception {
    public WrongNumberOfParamsException(String methodName, int expected, int found) {
        super("Wrong number of params found for method " + methodName + ", required " + expected + " but found " + found + ".");
    }
}
