package racingcar.domain.exception;

public class InvalidCarCountException extends RuntimeException {

    private static final String MESSAGE = "잘못된 자동차 갯수입니다.";

    public InvalidCarCountException() {
        super(MESSAGE);
    }
}
