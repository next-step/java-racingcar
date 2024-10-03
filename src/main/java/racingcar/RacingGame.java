package racingcar;

public class RacingGame {
    private RacingGame() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static int[][] race(int carCount, int attemptCount, MoveStrategy moveStrategy) {
        Car[] carArray = createCars(carCount);
        int[][] raceResults = new int[attemptCount][carCount];
        for (int attempt = 0; attempt < attemptCount; attempt++) {
            raceResults[attempt] = runAttempt(carArray, moveStrategy);
        }
        return raceResults;
    }

    private static int[] runAttempt(Car[] carArray, MoveStrategy moveStrategy) {
        int[] attemptResult = new int[carArray.length];
        for (int i = 0; i < carArray.length; i++) {
            carArray[i].move(moveStrategy);
            attemptResult[i] = carArray[i].getPosition();
        }
        return attemptResult;
    }

    private static Car[] createCars(int carCount) {
        Car[] cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            cars[i] = new Car();
        }
        return cars;
    }

}
