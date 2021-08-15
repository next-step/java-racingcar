package racingcar.domain;

public class RacingGame {
    private RoundCount roundCount;
    private MovableStrategy movableStrategy;

    public RacingGame(RoundCount roundCount, MovableStrategy movableStrategy) {
        this.roundCount = roundCount;
        this.movableStrategy = movableStrategy;
    }

    public RaceResult race(Cars cars) {
        RaceResult raceResult = new RaceResult(roundCount, cars.getCars());
        for (int i = 0; i < roundCount.getValue(); i++) {
            cars.moveCars(movableStrategy);
            raceResult.report(cars.getCars());
        }
        return raceResult;
    }
}
