package stringCalculator.exception;

public class OperatorException extends IllegalArgumentException {

    public OperatorException() {
        super("사칙 연산자가 아닙니다.");
    }
}
