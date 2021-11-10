package racingcar.exception;

public class NotEmptyCarNameException extends IllegalArgumentException {
    public NotEmptyCarNameException() {
            super("자동차의 이름은 빈 문자열일 수 없습니다.");
        }
}
