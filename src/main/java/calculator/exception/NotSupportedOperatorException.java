package calculator.exception;


public class NotSupportedOperatorException extends IllegalArgumentException {
    public NotSupportedOperatorException() {
        super("사칙연산 기호가 아닙니다.");
    }
}
