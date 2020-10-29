package step2.exception;

public class NotOperatorException extends IllegalArgumentException{
    public NotOperatorException() {
        super("맞지 않은 연산자가 입력되었습니다.");
    }
}
