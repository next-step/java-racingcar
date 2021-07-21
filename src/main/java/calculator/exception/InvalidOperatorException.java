package calculator.exception;

public class InvalidOperatorException extends RuntimeException {

    private static final String MESSAGE = "유효한 연산자가 아닙니다. 연산자는 '+', '-', '*', '/' 중 하나여야 합니다.";

    public InvalidOperatorException() {
        super(MESSAGE);
    }
}
