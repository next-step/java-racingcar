package step1;

public class IllegalFormulaFormatException extends IllegalArgumentException {
    public IllegalFormulaFormatException() {
    }

    public IllegalFormulaFormatException(final String s) {
        super(s);
    }

    public IllegalFormulaFormatException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public IllegalFormulaFormatException(final Throwable cause) {
        super(cause);
    }
}
