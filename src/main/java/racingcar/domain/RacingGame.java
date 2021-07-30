package racingcar.domain;

public class RacingGame {
    private int roundCount;
    private int currentRound = 0;
    private MovableStrategy movableStrategy;

    public RacingGame(int roundCount, MovableStrategy movableStrategy) {
        checkGreaterThanZero(roundCount);
        this.roundCount = roundCount;
        this.movableStrategy = movableStrategy;
    }

    private void checkGreaterThanZero(int roundCount) {
        if (roundCount < 1) {
            throw new IllegalArgumentException("라운드 수는 0보다 커야합니다.");
        }
    }

    public void race(Cars cars) {
        cars.moveCars(movableStrategy);
        currentRound++;
    }

    public boolean isEnd() {
        return currentRound >= roundCount;
    }
}
