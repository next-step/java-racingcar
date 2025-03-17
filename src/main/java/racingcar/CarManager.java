package racingcar;

import java.util.Random;

public class CarManager {

    public static final int MAX_RAND_VALUE = 9;
    public static final int MIN_MOVE_VALUE = 4;

    public static Car[] prepareCar(int carCount) {
        Car[] cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            cars[i] = new Car();
        }
        return cars;
    }

    public static Car[] moveCar(Car[] cars) {
        for (Car car : cars) {
            if (canMove()) {
                car.move();
            }
        }
        return cars;
    }

    public static boolean canMove() {
        Random rand = new Random();
        return rand.nextInt(MAX_RAND_VALUE) >= MIN_MOVE_VALUE;
    }

}
