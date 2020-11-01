package exception;

public class DividedByZeroException extends ArithmeticException {
    public DividedByZeroException() {
        super(ExceptionMessage.DIVIDED_BY_ZERO);
    }
}
