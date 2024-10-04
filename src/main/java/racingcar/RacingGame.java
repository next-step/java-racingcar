package racingcar;

public class RacingGame {
    private final MoveStrategy moveStrategy;

    public RacingGame(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public RaceResult race(int carCount, int attemptCount) {
        Car[] carArray = createCars(carCount);
        RaceResult raceResult = new RaceResult(attemptCount);
        for (int attempt = 0; attempt < attemptCount; attempt++) {
            AttemptResult attemptResult = runAttempt(carArray);
            raceResult.addAttemptResult(attemptResult, attempt);
        }
        return raceResult;
    }

    private AttemptResult runAttempt(Car[] carArray) {
        int[] positions = new int[carArray.length];
        for (int i = 0; i < carArray.length; i++) {
            carArray[i].move(moveStrategy);
            positions[i] = carArray[i].getPosition();
        }
        return new AttemptResult(positions);
    }

    private Car[] createCars(int carCount) {
        Car[] cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            cars[i] = new Car();
        }
        return cars;
    }
}
