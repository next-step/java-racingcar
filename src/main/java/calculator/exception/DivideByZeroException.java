package calculator.exception;

/**
 * Created by owen.ny on 2021/11/04.
 */
public class DivideByZeroException extends ArithmeticException {
    public DivideByZeroException() {
        super("0으로 나눌 수 없습니다.");
    }
}
