package racingcar;

import java.util.List;
import java.util.Random;

public class RacingGame {
    public static void race(int carNumber, int moveNumber) {
        Random random = new Random();
        Cars cars = Cars.create(carNumber);
        for (int i = 0; i < moveNumber; i++) {
            cars.moving();
            cars.print();
        }
    }
}
