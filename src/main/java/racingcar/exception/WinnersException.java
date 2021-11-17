package racingcar.exception;

public class WinnersException extends RuntimeException {
    private static String MESSAGE = "우승자가 없습니다.";

    public WinnersException() {
        super(MESSAGE);
    }
}
