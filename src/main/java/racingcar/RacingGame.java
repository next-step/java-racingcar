package racingcar;

import racingcar.car.CarCollection;
import racingcar.car.RandomEngine;

public class RacingGame {

    private int numberOfTry;
    private CarCollection cars;

    public RacingGame(int numberOfTry, int numberOfCars) {
        this.numberOfTry = numberOfTry;
        this.cars = new CarCollection(numberOfCars, RandomEngine.class);
    }

    public RacingGameResult run() {
        drive();
        return cars.getResult();
    }

    private void drive() {
        for(int i = 0; i < numberOfTry; i++) {
            cars.move();
        }
    }
}
