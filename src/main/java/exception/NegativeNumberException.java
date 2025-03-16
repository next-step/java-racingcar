package exception;

public class NegativeNumberException extends RuntimeException {
    public NegativeNumberException() { super("negative number is not allowed."); }
}
