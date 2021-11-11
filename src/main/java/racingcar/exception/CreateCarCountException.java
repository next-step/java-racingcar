package racingcar.exception;

public class CreateCarCountException extends RuntimeException {
    private static final String MESSAGE = "자동차 이름을 입력해 주세요.";

    public CreateCarCountException() {
        super(MESSAGE);
    }
}
