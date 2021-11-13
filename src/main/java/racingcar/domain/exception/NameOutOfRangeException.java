package racingcar.domain.exception;

public class NameOutOfRangeException extends IllegalArgumentException {

    private static final String MESSAGE = "이름의 최대 길이인 %s을 초과하였습니다.";

    public NameOutOfRangeException(int size) {
        super(String.format(MESSAGE, size));
    }

}
