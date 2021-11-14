package racingcar.exception;

public class PositionException extends RuntimeException {
    private static final String MESSAGE = "Position 값(%d)이 잘못 되었습니다.";

    public PositionException(int position) {
        super(String.format(MESSAGE, position));
    }
}
