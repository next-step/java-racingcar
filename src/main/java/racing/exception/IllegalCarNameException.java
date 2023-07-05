package racing.exception;

public class IllegalCarNameException extends RacingBaseException {
    private static final String MESSAGE = "자동차 이름이 올바르지 않습니다. 자동차의 이름은 1글자에서 5글자 사이여야 합니다.";

    public IllegalCarNameException() {
        super(MESSAGE);
    }
}
