package calculator.exception;

public class InvalidValueException extends IllegalArgumentException {

    public InvalidValueException() {
        super("Value cannot be null or empty");
    }
}
