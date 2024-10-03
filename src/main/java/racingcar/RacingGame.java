package racingcar;

public class RacingGame {
    private RacingGame() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static RaceResult race(int carCount, int attemptCount, MoveStrategy moveStrategy) {
        Car[] carArray = createCars(carCount);
        RaceResult raceResult = new RaceResult(attemptCount);
        for (int attempt = 0; attempt < attemptCount; attempt++) {
            AttemptResult attemptResult = runAttempt(carArray, moveStrategy);
            raceResult.addAttemptResult(attemptResult, attempt);
        }
        return raceResult;
    }

    private static AttemptResult runAttempt(Car[] carArray, MoveStrategy moveStrategy) {
        int[] positions = new int[carArray.length];
        for (int i = 0; i < carArray.length; i++) {
            carArray[i].move(moveStrategy);
            positions[i] = carArray[i].getPosition();
        }
        return new AttemptResult(positions);
    }

    private static Car[] createCars(int carCount) {
        Car[] cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            cars[i] = new Car();
        }
        return cars;
    }

}
