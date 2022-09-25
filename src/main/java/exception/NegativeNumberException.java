package exception;

public class NegativeNumberException extends RuntimeException {
    public NegativeNumberException() {
        super("Negative number can't be input.");
    }
}
