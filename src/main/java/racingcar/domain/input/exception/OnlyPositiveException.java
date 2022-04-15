package racingcar.domain.input.exception;

public class OnlyPositiveException extends IllegalArgumentException {

    private static final String ONLY_POSITIVE = "1 이상의 값만 가능합니다.";

    public OnlyPositiveException() {
        super(ONLY_POSITIVE);
    }

    public OnlyPositiveException(String message) {
        super(message);
    }
}
