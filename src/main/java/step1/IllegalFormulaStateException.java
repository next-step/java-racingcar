package step1;

public class IllegalFormulaStateException extends IllegalStateException {
    public IllegalFormulaStateException() {
    }

    public IllegalFormulaStateException(final String s) {
        super(s);
    }

    public IllegalFormulaStateException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public IllegalFormulaStateException(final Throwable cause) {
        super(cause);
    }
}
