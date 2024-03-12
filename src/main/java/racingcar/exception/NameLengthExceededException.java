package racingcar.exception;

public class NameLengthExceededException extends RuntimeException {

    public NameLengthExceededException() {
        super("자동차 이름은 5자를 초과할 수 없습니다.");
    }

}
