package calculator.exception;

/**
 * Created by owen.ny on 2021/11/04.
 */
public class NotSupportedOperatorException extends IllegalArgumentException {
    public NotSupportedOperatorException() {
        super("사칙연산 기호가 아닙니다.");
    }
}
