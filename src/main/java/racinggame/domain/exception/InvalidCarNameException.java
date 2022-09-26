package racinggame.domain.exception;

public class InvalidCarNameException extends RuntimeException {

    public InvalidCarNameException() {
        super("자동차 이름의 길이는 0 초과 5 미만입니다.");
    }
}
