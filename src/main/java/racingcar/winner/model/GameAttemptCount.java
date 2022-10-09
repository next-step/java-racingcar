package racingcar.winner.model;


import racingcar.winner.exception.InvalidInputException;

public class GameAttemptCount {
    private static final int LAST_VALUE = 0;
    private final int value;

    public GameAttemptCount(final int value) {
        if (value < 0) {
            throw new InvalidInputException("시도할 회수가 유효하지 않습니다");
        }

        this.value = value;
    }

    public GameAttemptCount play() {
        return new GameAttemptCount(this.value - 1);
    }

    public boolean isEnded() {
        return this.value <= LAST_VALUE;
    }
}
