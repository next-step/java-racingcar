package calculator.exception;

public class DivideByZeroException extends ArithmeticException {
    public DivideByZeroException() {
        super("0으로 나눌 수 없습니다.");
    }
}
