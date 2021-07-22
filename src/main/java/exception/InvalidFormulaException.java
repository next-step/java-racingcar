package exception;

public class InvalidFormulaException extends RuntimeException {
    public InvalidFormulaException() {
        this("올바른 수식이 아닙니다.");
    }

    public InvalidFormulaException(String message) {
        super(message);
    }

    public InvalidFormulaException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidFormulaException(Throwable cause) {
        super(cause);
    }

    protected InvalidFormulaException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
