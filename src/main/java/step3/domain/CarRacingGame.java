package step3.domain;

import step3.factory.CarFactory;
import step3.model.Car;

import java.util.List;

public class CarRacingGame {

    private List<Car> cars;
    private int numberOfAttempts;

    public CarRacingGame(int numberOfCars, int numberOfAttempts) {
        this.cars = CarFactory.create(numberOfCars);
        this.numberOfAttempts = numberOfAttempts;
    }

    public void start() {
        for (int i = 0; i < numberOfAttempts; i++) {
            cars.forEach(car -> car.move(CarRacingManager.getForwardDistance()));
            CarRacingScoreboard.recordScoreboard(cars);
        }
    }

}
