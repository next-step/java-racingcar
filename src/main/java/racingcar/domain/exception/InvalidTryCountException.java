package racingcar.domain.exception;

public class InvalidTryCountException extends RuntimeException {

    private static final String MESSAGE = "시도횟수는 0보다 큰 숫자여야 합니다.";

    public InvalidTryCountException() {
        super(MESSAGE);
    }
}
