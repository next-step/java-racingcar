package racingcar.exception;

public class TooLongCarNameException extends IllegalArgumentException {
    public TooLongCarNameException() {
            super("0으로 나눌 수 없습니다.");
        }
}
