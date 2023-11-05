package racingcar.model;

import java.util.Arrays;

public class RacingGame {

    private final Car[] cars;

    public RacingGame(int numberOfCars) {
        this.cars = new Car[numberOfCars];
        Arrays.setAll(cars, i -> new Car());
    }

    public void moveOnce() {
        for (Car car : cars) {
            car.moveCar();
        }
    }

    public void printOnce() {
        for (Car car : cars) {
            car.printPosition();
        }
    }
}