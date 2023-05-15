package racingcar;

import java.util.Arrays;
import java.util.Random;
import racingcar.UI.ResultView;

public class RacingGame {
    private static final Random RANDOM = new Random();
    private static final int RANDOM_VALUE = 10;

    private static Car[] createCars(int num) {
        Car[] cars = new Car[num];
        for (int i = 0; i < num; i++) {
            cars[i] = new Car();
        }
        return cars;
    }

    private static int getRandomValue() {
        return RANDOM.nextInt(RANDOM_VALUE);
    }

    private static void playRound(Car[] cars) {
        Arrays.stream(cars).forEach(car -> {
            int randomValue = getRandomValue();
            car.stopOrMove(randomValue);
        });
    }

    public static void playGame(int numberOfCar, int tryCount) {
        Car[] cars = createCars(numberOfCar);

        for (int i = 0; i < tryCount; i++) {
            playRound(cars);
            ResultView.printRound(cars);
        }
    }
}
