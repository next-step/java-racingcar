package racingcar;

import java.util.Random;

public class RacingGame {
    private static final Random RANDOM = new Random();
    private static final int RANDOM_BOUND = 10;

    private RacingGame() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static void play() {
        int carCount = InputView.getCarCount();
        int attemptCount = InputView.getAttemptCount();
        Car[] cars = createCars(carCount);
        ResultView.printExecuteResult();
        for (int i = 0; i < attemptCount; i++) {
            moveAndPrint(cars);
            ResultView.nextAttempt();
        }
    }

    private static void moveAndPrint(Car[] cars) {
        for (Car car : cars) {
            int randomNumber = RANDOM.nextInt(RANDOM_BOUND);
            car.move(randomNumber);
            ResultView.print(car.getMoveCount());
        }
    }

    private static Car[] createCars(int count) {
        Car[] cars = new Car[count];
        for (int i = 0; i < count; i++) {
            cars[i] = new Car();
        }
        return cars;
    }
}
