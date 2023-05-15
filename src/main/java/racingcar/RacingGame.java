package racingcar;

import java.util.Arrays;
import racingcar.UI.ResultView;

public class RacingGame {

    private static Car[] createCars(int num) {
        Car[] cars = new Car[num];
        for (int i = 0; i < num; i++) {
            cars[i] = new Car();
        }
        return cars;
    }

    private static void playRound(Car[] cars) {
        Arrays.stream(cars).forEach(Car::stopOrMove);
    }

    public static void playGame(int numberOfCar, int tryCount) {
        Car[] cars = createCars(numberOfCar);

        for (int i = 0; i < tryCount; i++) {
            playRound(cars);
            ResultView.printRound(cars);
        }
    }
}
