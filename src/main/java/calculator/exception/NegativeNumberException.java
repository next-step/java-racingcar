package calculator.exception;

public class NegativeNumberException extends BusinessException {
    public NegativeNumberException() {
        super("음수는 입력이 불가능합니다.");
    }
}
