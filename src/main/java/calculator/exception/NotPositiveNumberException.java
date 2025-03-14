package calculator.exception;

public class NotPositiveNumberException extends RuntimeException {

    public NotPositiveNumberException() {
        super("양수만 입력해주세요.");
    }

}
