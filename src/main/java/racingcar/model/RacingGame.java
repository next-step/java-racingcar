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
            car.moveCar(car.tryToMove(car.generateRandomNumber()));
        }
    }

    public String[] getCarsDistance() {
        String[] distances = new String[cars.length];

        for (int i = 0; i < cars.length; i++) {
            distances[i] = cars[i].getDistance();
        }

        return distances;
    }
}