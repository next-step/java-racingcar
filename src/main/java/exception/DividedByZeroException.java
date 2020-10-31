package exception;

public class DividedByZeroException extends ArithmeticException {
    public DividedByZeroException() {
        super(ErrorMessage.DIVIDED_BY_ZERO);
    }
}
