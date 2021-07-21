package calculator.exception;

public class InputBlankException extends ArithmeticException {
    private static final String MESSAGE = "입력 값이 null 이거나 빈 공백 문자 입니다.";

    public InputBlankException() {
        super(MESSAGE);
    }
}
