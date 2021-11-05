package racingcar;

public class TryCountException extends RuntimeException {
    private static final String MESSAGE = "시도 횟수(%d)를 잘못 입력했습니다.";

    public TryCountException(int tryCount) {
        super(String.format(MESSAGE, tryCount));
    }
}
