package exception;

public class InValidOperatorException extends IllegalArgumentException {
    public InValidOperatorException() {
        super("사칙연산 기호가 아닙니다.");
    }
}
