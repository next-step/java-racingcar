package secondStage.exception;

public class EmptyException extends IllegalArgumentException {

    public EmptyException() {
        super("빈 문자열을 사용할 수 없습니다.");
    }
}
