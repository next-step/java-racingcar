package calculator;

public class IllegalOperandException extends RuntimeException {


    public IllegalOperandException() {
    }

    public IllegalOperandException(String message) {
        super(message);
    }

    public IllegalOperandException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalOperandException(Throwable cause) {
        super(cause);
    }

    public IllegalOperandException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
