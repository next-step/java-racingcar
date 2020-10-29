package step2.exception;

public class EmptyException extends IllegalArgumentException{
    public EmptyException() {
        super("빈 공백을 입력하셨습니다.");
    }
}
