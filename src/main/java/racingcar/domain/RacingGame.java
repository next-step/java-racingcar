package racingcar.domain;

public class RacingGame {
    private int roundCount;
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

    public RaceResult race(Cars cars) {
        RaceResult raceResult = new RaceResult();
        for (int i = 0; i < roundCount; i++) {
            cars.moveCars(movableStrategy);
            raceResult.report(i+1, cars);
        }
        raceResult.reportWinners(cars.findWinners());
        return raceResult;
    }
}
