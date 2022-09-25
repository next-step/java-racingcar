package exception;

public class NegativeNumberException extends IllegalArgumentException {
    private static final String MESSAGE = "Negative number can't be input.";

    public NegativeNumberException() {
        super(MESSAGE);
    }
}