package service;

import java.util.List;
import java.util.Random;

import domain.Car;

public class CarRace {

    private static final int MIN_LIMIT_NUMBER = 4;
    private static final int MAX_LIMIT_BOUND_NUMBER = 10;

    public List<Car> updateCurrentLocation(List<Car> racingCars) {

        for (Car car : racingCars) {
            int randomNum = generateRandomNum();
            car.move(isMovingForward(randomNum));
        }
        return racingCars;
    }

    private int generateRandomNum() {
        Random random = new Random();
        return random.nextInt(MAX_LIMIT_BOUND_NUMBER);
    }

    private boolean isMovingForward(int randomNumber) {
        return randomNumber >= MIN_LIMIT_NUMBER;
    }

}
