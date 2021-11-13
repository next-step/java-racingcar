package racingcar.exception;

public class RoundException extends RuntimeException {
    private static final String MESSAGE = "Round 가 초과 했습니다.";

    public RoundException() {
        super(MESSAGE);
    }
}
