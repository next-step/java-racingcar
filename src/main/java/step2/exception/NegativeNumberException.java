package step2.exception;

public class NegativeNumberException extends RuntimeException{
    public NegativeNumberException() {
        super("음수는 입력할 수 없습니다.");
    }
}
