package exception;

public class InvalidOperatorException extends IllegalArgumentException {

    public InvalidOperatorException() {
        super("Operator is invalid");
    }
}
