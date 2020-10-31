package step2.exception;

public class BlankException extends IllegalArgumentException{
    public BlankException() {
        super("빈 공백을 입력하셨습니다.");
    }
}
