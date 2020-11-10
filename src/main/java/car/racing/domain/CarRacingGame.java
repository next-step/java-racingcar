package car.racing.domain;

import car.racing.Forwardable;

import java.util.List;

public class CarRacingGame {

    private final Forwardable forwardable;
    private final List<Car> cars;

    public CarRacingGame(List<Car> cars, Forwardable forwardable) {
        this.cars = cars;
        this.forwardable = forwardable;
    }

    public void forwardCarEachTry() {
        cars.forEach(car -> car.forward(forwardable));
    }

    public List<Car> getCars() {
        return cars;
    }
}