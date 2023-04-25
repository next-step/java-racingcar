package racingcar.exception;

public class InvalidGameRoundNumberException extends RuntimeException {

    public static final String INVALID_NUMBER_MESSAGE = "자동차 시도 횟수는 양수만 입력 가능합니다";

    public InvalidGameRoundNumberException() {
        super(INVALID_NUMBER_MESSAGE);
    }
}
