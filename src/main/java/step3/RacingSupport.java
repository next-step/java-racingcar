package step3;

import java.util.Random;

public class RacingSupport {

    static Car[] prepareCar(Integer carCount) {
        Car[] cars = new Car[carCount];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car();
        }

        return cars;
    }

    static Car[] raceEachCar(Car[] preparedCar) {
        for (int j = 0; j < preparedCar.length; j++) {
            preparedCar = moveByRandom(isRandomGreaterThanThree(), preparedCar, j);
        }

        return preparedCar;

    }

    static Car[] moveByRandom(Boolean isMove, Car[] preparedCars, Integer j) {
        if (isMove) {;
            preparedCars[j].moveForward();
            return preparedCars;
        }

        return preparedCars;
    }

    private static Boolean isRandomGreaterThanThree() {
        int random = new Random().nextInt(10);
        if (random > 3) {
            return true;
        }

        return false;
    }
}
