package exception;

public class DividedByZero extends ArithmeticException {
    public DividedByZero() {
        super(ErrorMessage.DIVIDED_BY_ZERO);
    }
}
