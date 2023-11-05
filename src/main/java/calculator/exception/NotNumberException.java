package calculator.exception;

public class NotNumberException extends BusinessException {
    public NotNumberException() {
        super("숫자가 아닌 값은 입력이 불가능합니다.");
    }
}
