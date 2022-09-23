package step2.exception;

public class InvalidStringException extends NumberFormatException{

    public InvalidStringException() {
        super("숫자와 구분자만 입력할 수 있습니다.");
    }
}
