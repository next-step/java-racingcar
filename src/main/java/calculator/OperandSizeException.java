package calculator;

public class OperandSizeException extends RuntimeException {

    public OperandSizeException(String message) {
        super(message);
    }

    public OperandSizeException(String message, Throwable cause) {
        super(message, cause);
    }
}
