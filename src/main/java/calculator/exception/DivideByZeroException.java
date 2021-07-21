package calculator.exception;

public class DivideByZeroException extends ArithmeticException {
    private static final String MESSAGE = "0으로 나누는 연산은 수행할 수 없습니다.";

    public DivideByZeroException() {
        super(MESSAGE);
    }
}
