package calculator.exception;

public class InvalidOperatorException extends IllegalArgumentException {
    private static final String MESSAGE = "올바른 사칙연산 기호가 아닙니다.";

    public InvalidOperatorException() {
        super(MESSAGE);
    }
}
