package calculator.exception;

public class InvalidNumberFormatException extends RuntimeException {

    public InvalidNumberFormatException() {
        super("숫자 이외의 값은 입력할 수 없습니다.");
    }

}
