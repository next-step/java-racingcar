package racingcar.domain.input.exception;

public class MaximumCarNameException extends IllegalArgumentException {

    private static final String MESSAGE = "자동차의 이름은 5자를 초과할 수 없습니다.";

    public MaximumCarNameException() {
        super(MESSAGE);
    }

    public MaximumCarNameException(String message) {
        super(message);
    }
}
