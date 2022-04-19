package racingcar.domain.input.exception;

public class RequiredCarNameException extends IllegalArgumentException {

    private static final String MESSAGE = "자동차 이름은 필수로 입력해야합니다.";

    public RequiredCarNameException() {
        super(MESSAGE);
    }

    public RequiredCarNameException(String message) {
        super(message);
    }
}
