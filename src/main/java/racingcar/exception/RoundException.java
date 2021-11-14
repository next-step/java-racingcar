package racingcar.exception;

public class RoundException extends RuntimeException {
    private static final String MESSAGE = "Round값이 잘못 되었습니다.";

    public RoundException() {
        super(MESSAGE);
    }
}
