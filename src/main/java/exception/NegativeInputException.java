package exception;

public class NegativeInputException extends IllegalArgumentException {
    public NegativeInputException(String errorMessage) {
        super(errorMessage);
    }
}