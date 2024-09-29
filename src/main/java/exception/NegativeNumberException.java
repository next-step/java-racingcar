package exception;

public class NegativeNumberException extends RuntimeException {
    public NegativeNumberException(int negativeNumber) {
        super("Negative numbers are not allowed: " + negativeNumber);
    }
}
